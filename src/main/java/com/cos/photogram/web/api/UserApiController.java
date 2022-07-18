package com.cos.photogram.web.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.user.User;
import com.cos.photogram.service.SubscribeService;
import com.cos.photogram.service.UserService;
import com.cos.photogram.web.dto.auth.CMRespDto;
import com.cos.photogram.web.dto.subscribe.SubscribeDto;
import com.cos.photogram.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {
	
	private final UserService userService;
	private final SubscribeService subscribeService;

	@PutMapping("/api/user/{id}")
	public CMRespDto<?> update(
			@PathVariable Long id, 
			@Valid UserUpdateDto userUpdateDto,
			BindingResult bindingResult,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {	
		
		User userEntity = userService.update(id, userUpdateDto.toEntity());
		principalDetails.setUser(userEntity);
		
		return new CMRespDto<>(1, "회원수정 완료", userEntity);
	}
	
	@GetMapping("/api/user/{pageUserId}/subscribe")
	public ResponseEntity<?> subscribeList(@PathVariable Long pageUserId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		List<SubscribeDto> subscribeDto = subscribeService.subscribeList(principalDetails.getUser().getId(), pageUserId);
		
		return new ResponseEntity<>(new CMRespDto<>(1, "구독 정보 목록 가져오기 성공", subscribeDto), HttpStatus.OK);
	}
	
	@PutMapping("/api/user/{principalId}/profileImageUrl")
	public ResponseEntity<?> profileImageUpdate(@PathVariable Long principalId, MultipartFile profileImageFile, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		User userEntity = userService.profileImageUpdate(principalId, profileImageFile);
		principalDetails.setUser(userEntity);
		
		return new ResponseEntity<>(new CMRespDto<>(1, "프로필 사진 변경 성공", null), HttpStatus.OK); 
	}
}
