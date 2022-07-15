package com.cos.photogram.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogram.domain.likes.LikesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LikesService {

	private final LikesRepository likesRepository;
	
	@Transactional
	public void likes(Long imageId, Long principalId) {
		likesRepository.likes(imageId, principalId);
	}
	
	@Transactional
	public void unLikes(Long imageId, Long principalId) {
		likesRepository.unLikes(imageId, principalId);
	}
}
