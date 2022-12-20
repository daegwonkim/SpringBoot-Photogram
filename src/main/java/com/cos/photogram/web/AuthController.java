package com.cos.photogram.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogram.domain.user.User;
import com.cos.photogram.service.AuthService;
import com.cos.photogram.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	//IoC, 파일을 리턴하는 Controller
public class AuthController {
	
	private final AuthService authService;

	/* 로그인 페이지 */
	@GetMapping("/auth/signin")
	public String signinForm() {
		
		return "auth/signin";
	}
	
	/* 회원가입 페이지 */
	@GetMapping("/auth/signup")
	public String signupForm() {
		
		return "auth/signup";
	}
	
	/* 회원가입 진행 */
	@PostMapping("/auth/signup")
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {
		
		//SignupDto -> User
		User user = signupDto.toEntity();
		authService.join(user);
		
		return "auth/signin";
	}
}
