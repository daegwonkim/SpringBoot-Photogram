package com.cos.photogram.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.user.User;
import com.cos.photogram.service.UserService;
import com.cos.photogram.web.dto.user.UserProfileDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;

	/* 사용자 프로필 페이지 */
	@GetMapping("/user/{pageUserId}")
	public String profile(@PathVariable Long pageUserId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		UserProfileDto userProfileDto = userService.profile(pageUserId, principalDetails.getUser().getId());
		model.addAttribute("dto", userProfileDto);
		
		return "user/profile";
	}
	
	/* 회원정보 수정 페이지 */
	@GetMapping("/user/{id}/update")
	public String update(@PathVariable Long id) {
		return "user/update";
	}
	
	/* 검색 */
	@GetMapping("/user/search")
	public String search(String search, Model model) {
		List<User> userEntityList = userService.search(search);
		model.addAttribute("users", userEntityList);
		
		return "user/search";
	}
}
