package org.joonzis.controller;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.print.attribute.standard.Severity;

import org.joonzis.domain.UserOrderVO;
import org.joonzis.domain.UserVO;
import org.joonzis.service.UserOrderService;
import org.joonzis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@Autowired
	private UserOrderService orderService;
	
	
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
		model.addAttribute("vo", service.selectUserId(vo.getUserId()));
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
	
	// 마이페이지 이동 
	@GetMapping("/myPage")
		public String myPage(Model model, UserVO vo) {
		
		UserVO result = service.userSelectOne(vo.getMno());
		
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
		log.warn("wjiofahjfiafesfgejsif" + userId);
		UserVO result = service.selectUserId(userId);
//		service.checkPassword(result);
		
		// 이메일 가져오기 코드
		String email = result.getUserEmail();
		String saveEmail = null;
		String saveDomain = null;	
		String[] arr = email.split("@");
		for (int i = 0; i < arr.length; i++) {
			log.info("문자열 자르기잉이이인ㅋ : " + arr[i]);
			saveEmail = arr[0];
			saveDomain = arr[1];
		}
		log.info("이메일 : " + saveEmail);
		log.info("도메인 : " + saveDomain);
		
		model.addAttribute("saveEmail", saveEmail);
		model.addAttribute("saveDomain", saveDomain);
		
		model.addAttribute("result", result);
		log.info("비밀번호 확인 : " + result.getUserId());
		log.info("비밀번호 확인 : " + result.getUserPw());
		
		return "/myPage/checkPassword";
	}
	
	
	// 유저 정보 수정 페이지 이동
	@GetMapping("/myPageUpdate")
		public String myPageUpdate(Model model,String userId) {
		log.warn("유저 정보 수정 페이지 이동" + userId);
		UserVO result = service.selectUserId(userId);
		
		// 이메일 가져오기 코드
		String email = result.getUserEmail();
		String saveEmail = null;
		String saveDomain = null;	
		String[] arr = email.split("@");
		for (int i = 0; i < arr.length; i++) {
			log.info("문자열 자르기잉이이인ㅋ : " + arr[i]);
			saveEmail = arr[0];
			saveDomain = arr[1];
		}
		log.info("이메일 : " + saveEmail);
		log.info("도메인 : " + saveDomain);
		
		model.addAttribute("saveEmail", saveEmail);
		model.addAttribute("saveDomain", saveDomain);
		
		model.addAttribute("result", result);
		log.info("마이페이지 수정 : " + result.getUserId());
		
		return "/myPage/myPageUpdate";
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
		UserVO result = service.selectUserId(userId);
		model.addAttribute("result", result);
		return "/myPage/myPage";
	}
	
	// 유저 정보 업데이트
	@PostMapping("/updateUserInfo")
		public String updateUserInfo(UserVO vo, Model model) {
		
		log.warn("유저 정보 업데" + vo.getUserDate());
		log.warn("유저정보 업데이트 :" + vo.getUserGender());
		log.warn("유저정보 업데이트 :" + vo.getUserPhonenumber());
		int result = service.updateUserInfo(vo);
		log.warn("dsadasdsadasdadwadwad" + result);
		// 이메일 가져오기 코드
		String email = vo.getUserEmail();
		String saveEmail = null;
		String saveDomain = null;	
		String[] arr = email.split("@");
		for (int i = 0; i < arr.length; i++) {
			log.info("문자열 자르기잉이이인ㅋ : " + arr[i]);
			saveEmail = arr[0];
			saveDomain = arr[1];
		}
		log.info("이메일 : " + saveEmail);
		log.info("도메인 : " + saveDomain);
		
		model.addAttribute("saveEmail", saveEmail);
		model.addAttribute("saveDomain", saveDomain);
		model.addAttribute("result", vo);
		return "/myPage/myPageUpdate";
	}
	
	// 유저 탈퇴
	@GetMapping("deleteAccount")
		public String deleteAccount(String userId) {
		log.info("회원탈퇴 : " + userId);
		service.deleteAccount(userId);
		return "/main";
	}
	
		@GetMapping("OrderSelect")
		public String userOrderSelect(Model model, UserVO vo) {
		log.info("vo@" + vo);
		log.info("mno컨트룰러 : " + vo.getMno());
		List<UserOrderVO> list = orderService.userOrderSelect(vo.getMno());
		list.forEach(uvo -> {
			log.warn("1 : " + uvo.getBno());
			log.warn("2 : " + uvo.getCount());
			log.warn("3 : " + uvo.getOrderAddr());
			log.warn("4 : " + uvo.getOrderStatus());
			log.warn("5 : " + uvo.getOrderPhone());
			log.warn("6 : " + uvo.getOrderDate());
			log.warn("7 : " + uvo.getTotalPrice());
		});
			model.addAttribute("vo",list);
			return "/myPage/myOrder";
	}
}
