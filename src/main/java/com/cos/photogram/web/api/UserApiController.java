package com.cos.photogram.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.user.User;
import com.cos.photogram.handler.ex.CustomValidationApiException;
import com.cos.photogram.service.UserService;
import com.cos.photogram.web.dto.auth.CMRespDto;
import com.cos.photogram.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {
	
	private final UserService userService;

	@PutMapping("/api/user/{id}")
	public CMRespDto<?> update(
			@PathVariable Long id, 
			@Valid UserUpdateDto userUpdateDto,
			BindingResult bindingResult,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			throw new CustomValidationApiException("유효성 검사에 실패하였습니다.", errorMap);
		}
		
		User userEntity = userService.update(id, userUpdateDto.toEntity());
		principalDetails.setUser(userEntity);
		
		return new CMRespDto<>(1, "회원수정 완료", userEntity);
	}
}
