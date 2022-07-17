package com.cos.photogram.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogram.domain.comment.Comment;
import com.cos.photogram.domain.comment.CommentRepository;
import com.cos.photogram.domain.image.Image;
import com.cos.photogram.domain.user.User;
import com.cos.photogram.domain.user.UserRepository;
import com.cos.photogram.handler.ex.CustomApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	
	@Transactional
	public Comment writeComment(String content, Long imageId, Long userId) {
		Image image = new Image();
		image.setId(imageId);
		
		User userEntity = userRepository.findById(userId).orElseThrow(() -> {
			return new CustomApiException("찾을 수 없는 사용자입니다.");
		});
		
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setImage(image);
		comment.setUser(userEntity);
		
		return commentRepository.save(comment);
	}
	
	@Transactional
	public void deleteComment(Long commentId) {
		try {
			commentRepository.deleteById(commentId);
		} catch(Exception e) {
			throw new CustomApiException(e.getMessage());
		}
	}
}
