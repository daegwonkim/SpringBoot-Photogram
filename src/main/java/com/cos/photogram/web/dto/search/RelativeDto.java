package com.cos.photogram.web.dto.search;

import java.util.List;

import com.cos.photogram.domain.image.Image;
import com.cos.photogram.domain.user.User;

import lombok.Data;

@Data
public class RelativeDto {

	private List<User> relativeUserDto;
	private List<Image> relativeTagDto;
}
