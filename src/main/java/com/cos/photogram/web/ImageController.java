package com.cos.photogram.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.image.Image;
import com.cos.photogram.handler.ex.CustomValidationException;
import com.cos.photogram.service.ImageService;
import com.cos.photogram.web.dto.image.ImageUploadDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ImageController {
	
	private final ImageService imageService;

	/* 스토리 페이지 */
	@GetMapping({"/", "/image/story"})
	public String story() {
		return "image/story";
	}
	
	/* 인기 페이지 */
	@GetMapping("/image/popular")
	public String popular(Model model) {
		List<Image> images = imageService.popular();
		model.addAttribute("images", images);
		
		return "image/popular";
	}
	
	/* 이미지 업로드 페이지 */
	@GetMapping("/image/upload")
	public String upload() {
		return "image/upload";
	}
}
