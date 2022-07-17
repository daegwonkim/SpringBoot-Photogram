package com.cos.photogram.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.comment.Comment;
import com.cos.photogram.handler.ex.CustomValidationApiException;
import com.cos.photogram.service.CommentService;
import com.cos.photogram.web.dto.auth.CMRespDto;
import com.cos.photogram.web.dto.comment.CommentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

	private final CommentService commentService;
	
	@PostMapping("/api/comment")
	public ResponseEntity<?> writeComment(@Valid @RequestBody CommentDto commentDto, BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			throw new CustomValidationApiException("유효성 검사에 실패하였습니다.", errorMap);
		}
		
		Comment comment = commentService.writeComment(commentDto.getContent(), commentDto.getImageId(), principalDetails.getUser().getId());
		
		return new ResponseEntity<>(new CMRespDto<>(1, "댓글 쓰기 성공", comment), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/api/comment/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
		commentService.deleteComment(commentId);
		return new ResponseEntity<>(new CMRespDto<>(1, "댓글 삭제 성공", null), HttpStatus.OK);
	}
}
