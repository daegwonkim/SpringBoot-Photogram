package com.cos.photogram.web.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CommentDto {

	@NotNull
	private Long imageId;
	
	@NotBlank
	private String content;
}
