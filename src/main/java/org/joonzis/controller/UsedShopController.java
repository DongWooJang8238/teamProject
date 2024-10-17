package org.joonzis.controller;

import org.joonzis.domain.Criteria;
import org.joonzis.domain.UsedBookVO;
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
		log.warn("컨트롤러 중고상점리스트 이동.." + cri);
		
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
		// 중고상품 등록 ( 대표이미지 = 리스트에 뿌려줄 이미지 )
		int result = service.usedShopInsert(vo);
		log.warn("컨트롤러 중고상품 등록 확인.." + result);
		// 중고 이미지 등록 ( 이미지가 있으면 등록, 없으면 미등록 )
		
		return "redirect:/used/list";
	}
}
