package com.cos.photogram.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogram.domain.user.User;
import com.cos.photogram.domain.user.UserRepository;
import com.cos.photogram.handler.ex.CustomValidationApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public User update(Long id, User user) {
		User userEntity = userRepository.findById(id).orElseThrow(() -> {
			return new CustomValidationApiException("회원정보 수정 실패: 회원 ID를 찾을 수 없습니다.");
		});
		
		userEntity.setName(user.getName());
		userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setWebsite(user.getWebsite());
		userEntity.setBio(user.getBio());
		userEntity.setPhone(user.getPhone());
		userEntity.setGender(user.getGender());

		return userEntity;
	}
}
