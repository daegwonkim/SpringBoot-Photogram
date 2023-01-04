package com.cos.photogram.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.photogram.domain.image.Image;
import com.cos.photogram.domain.user.User;
import com.cos.photogram.service.ImageService;
import com.cos.photogram.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyController {
	
	private final UserService userService;
	private final ImageService imageService;
	
	/* 검색 */
	@GetMapping("/search")
	public String search(@RequestParam String keyword, Model model) {
		List<User> userSearchList = userService.userSearch(keyword);
		List<Image> imageSearchList = imageService.imageSearch(keyword);
		
		model.addAttribute("users", userSearchList);
		model.addAttribute("images", imageSearchList);
		
		return "search";
	}
}
