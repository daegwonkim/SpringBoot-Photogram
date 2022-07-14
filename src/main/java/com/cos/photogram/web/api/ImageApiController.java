package com.cos.photogram.web.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.image.Image;
import com.cos.photogram.service.ImageService;
import com.cos.photogram.web.dto.auth.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ImageApiController {

	private final ImageService imageService;
	
	@GetMapping("/api/image")
	public ResponseEntity<?> story(@AuthenticationPrincipal PrincipalDetails principalDetails, 
			@PageableDefault(size = 3) Pageable pageable) {
		Page<Image> images = imageService.story(principalDetails.getUser().getId(), pageable);
		return new ResponseEntity<>(new CMRespDto<>(1, "이미지 스토리 불러오기 성공", images), HttpStatus.OK);
	}
}
