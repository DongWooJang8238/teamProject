package org.joonzis.controller;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.joonzis.domain.GameVO;
import org.joonzis.domain.UserVO;
import org.joonzis.service.GameService;
import org.joonzis.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;



@Log4j
@Controller
@RequestMapping("/report/*")
public class reportController {
	
	
	@Autowired
	private ReportService reportservice;
	
	
	//game entrance page open.
	@GetMapping("/Category")
	public String Category(@RequestParam("mno") int mno, Model model) {
		log.info("Category...");
		
		
		model.addAttribute("mno", mno);
		return "/report/Category";
	}
	
	@GetMapping("/qna")
    public String qna(int gameMode,int mno, Model model) {
		log.warn("qna...............................");
        model.addAttribute("mno", mno);
        return "/report/qna";  
    }
	@GetMapping("/oneonetwo")
	public String oneonetwo(int gameMode,int mno, Model model) {
		log.warn("oneonetwo...............................");
		model.addAttribute("gameMode", gameMode);
		model.addAttribute("mno", mno);
		return "/report/oneonetwo";  
	}
	

	
	
	
	
	
	
	
	
	
	
	

}
