package org.joonzis.controller;

import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.print.attribute.standard.Severity;

import org.joonzis.domain.UserVO;
import org.joonzis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/User/*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "/main";
	}
	
	@GetMapping("/login")
	public String login() {
		log.info("로그인 페이지 이동");
		return "/login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		log.info("회원가입 페이지 이동");
		return "/signup";
	}
	
	@PostMapping("/signup")
	public String signup(UserVO vo) {
		int result = service.signup_insert(vo);
		log.warn("Controller 회원가입 성공 : " + result);
		return "/main";
		
	}
	
	@PostMapping("/goLogin")
	public String goLogin(UserVO vo, Model model) {
		log.info("Controller 로그인 성공 : " + vo);
		model.addAttribute("vo", vo.getUserId());
		return "/main";
	}
	
	@GetMapping("/findId")
	public String findId() {
		log.info("아이디 찾기 페이지 이동");
		return "/find/findId";
	}
	
	@GetMapping("/findPw")
	public String findPw() {
		log.info("비밀번호 찾기 페이지 이동");
		return "/find/findPw";
	}
	
	// 아이디 찾기 후 - 유저 아이디 출력 페이지 이동
	@PostMapping("/goFindId")
	public String goFindId(Model model, UserVO vo) {
		UserVO result = service.selectUserIdByEmail(vo);
		log.info("아이디 찾기 검색 페이지 이동 : " + result.getUserId());
		model.addAttribute("userId", result.getUserId());
		return "/find/goFindId";
	}
	
	// 인증번호 인증 완료 - 새 비밀번호 페이지 이동
	@PostMapping("/pw_auth_page")
		public String pw_auth(Model model, int num, UserVO vo){
		log.info("---------------------------" + num);
		log.info("---------------------------" + vo.getUserId());
		model.addAttribute("userId", vo.getUserId());
		model.addAttribute("model", num);
		return "/find/pwAuth";
	}
	
	// 새 비밀번호 설정 페이지 이동
	@PostMapping("/pwNew")
		public String pwNew(Model model,UserVO vo) {
		model.addAttribute("userId", vo.getUserId());
		log.info("새 비밀번호 설정 페이지 이동 : " + vo.getUserId());
		return "/find/pwNew";
	}
	
	// 새 비밀번호 설정 완료 - 메인페이지
	@PostMapping("/pwChange")
		public String pwChange(UserVO vo) {
		int result = service.updatePw(vo);
		log.info("새 비밀번호 설정 완료 : " + result);
		
		return "/main";
	}
	
	// 마이페이지 이동 - 아이디 검색
	@GetMapping("/myPage")
		public String myPage(Model model, String userId) {
		log.info("------------------" + userId);
		UserVO result = service.selectUserId(userId);
		
		// 이름 암호화 처리
		String name = result.getUserName();
		
		
		if(name.length() == 2) {
			name = name.charAt(0) + "*";
			result.setUserName(name);
		}else if(name.length() == 3) {
			name = name.charAt(0) + "*" + name.charAt(2);
			result.setUserName(name);
		}else if(name.length() == 4) {
			name = name.charAt(0) + "*" + name.charAt(2) + name.charAt(3);
			result.setUserName(name);
		}else{
            name = name.charAt(0) + "*" + name.charAt(2);
            for (int i = 3; i < name.length(); i++) {
               name += name.charAt(i);
               log.warn("for *네임 : " + name);
            }
            log.warn("*네임 : " + name);
         }
		
		// 권한 예외처리
		String userRole = result.getUserRole();
		switch (userRole) {
		case "USER_ROLE":
			result.setUserRole("일반 유저");
			break;
		case "MANAGER_ROLE":
			
			break;
		case "ADMIN_ROLE":
			
			break;
		default:
			
			break;
		}
		
         
		log.info("마이페이지 이동" + result);
		model.addAttribute("result", result);
		
		
		return "/myPage/myPage";
	}
	
	// 유저 정보 수정 페이지 이동
	@GetMapping("/checkPassword")
		public String checkPassword(Model model,String userId) {
		UserVO result = service.selectUserId(userId);
//		service.checkPassword(result);
		
		model.addAttribute("result", result);
		log.info("비밀번호 확인 : " + result.getUserId());
		log.info("비밀번호 확인 : " + result.getUserPw());
		
		return "/myPage/checkPassword";
	}
	
	
	// 유저 정보 수정 페이지 이동
	@GetMapping("/myPageUpdate")
		public String myPageUpdate(Model model,String userId) {
		UserVO result = service.selectUserId(userId);
		model.addAttribute("result", result);
		log.info("마이페이지 수정 : " + result.getUserId());
		
		return "/myPage/myPage";
	}
	
	// 유저 아이콘 페이지 이동
	@GetMapping("/changeIcon")
		public String changeIcon(Model model,String userId) {
		UserVO result = service.selectUserId(userId);
		model.addAttribute("result", result);
		log.info("유저 아이콘 변경 페이지 이동");
		return "/myPage/changeIcon";
	}
	
	@PostMapping("/goChangeIcon")
		public String goChangeIcon(Model model, String userId) {
		
		return "/myPage/myPage";
	}
	
	
	
}
