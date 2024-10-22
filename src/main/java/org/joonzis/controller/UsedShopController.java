package org.joonzis.controller;

import org.joonzis.domain.Criteria;
import org.joonzis.domain.PageDTO;
import org.joonzis.domain.UsedBookVO;
import org.joonzis.domain.usedBookImgVO;
import org.joonzis.service.UsedShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/used")
public class UsedShopController {
	
	@Autowired
	UsedShopService service;
	
	@GetMapping("/list")
	public String goList(Criteria cri, Model model) {
		
		log.warn("list 컨트롤러 : " + cri);
		log.warn("컨트롤러 장르 번호 : " + cri.getGener());
		
		if (cri.getPageNum() == 0 || cri.getAmount() == 0) {
			cri.setPageNum(1);
			cri.setAmount(10);
		}
		
		
		if(cri.getGener() == 0) {
			int total = service.getTotal();
			log.info("total..." + total);
			
			model.addAttribute("list", service.getuBookList(cri));
			model.addAttribute("pageMaker", new PageDTO(cri, total));
			
		}else if(cri.getGener() > 0) {
			int total = service.getTotalByGno(cri.getGener());
			log.info("total..." + total);
			model.addAttribute("list", service.getuBookListGe(cri));
			model.addAttribute("pageMaker", new PageDTO(cri, total));
		}
		
		return "/usedShop/usedShopList";
	}
	
	@GetMapping("/goInsert")
	public String goInsert() {
		log.warn("컨트롤러 중고상품등록페이지 이동..");
		return "usedShop/usedShopInsert";
	}
	
	@PostMapping("/insert")
	public String usedShopInsert(UsedBookVO vo) {
		log.warn("컨트롤러 중고상품등록..." + vo);
		if(vo.getUsedBookImgs() != null) {
			for (usedBookImgVO ubivo : vo.getUsedBookImgs()) {
				log.warn("컨트롤러 중고상품 이미지 : " + ubivo.getUbookimages());
			}
		}
		// 중고상품 등록 ( 대표이미지 = 리스트에 뿌려줄 이미지 )
		int result = service.usedShopInsert(vo);
		log.warn("컨트롤러 중고상품 등록 확인.." + result);
		return "redirect:/used/list?genre=0&pageNum=1&amount=10";
	}
}
