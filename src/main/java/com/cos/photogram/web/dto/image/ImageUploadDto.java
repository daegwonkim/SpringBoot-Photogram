package com.cos.photogram.web.dto.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cos.photogram.domain.image.Image;
import com.cos.photogram.domain.user.User;

import lombok.Data;

@Data
public class ImageUploadDto {

	private MultipartFile file;
	private String caption;
	private List<String> hashtagList;
	
	public Image toEntity(User user, String post_image_url) {
		String hashtag = "";
		for(String str : hashtagList) {
			hashtag += str + ",";
		}
		
		return Image.builder()
				.user(user)
				.post_image_url(post_image_url)
				.caption(caption)
				.hashtag(hashtag)
				.build();
	}
}
