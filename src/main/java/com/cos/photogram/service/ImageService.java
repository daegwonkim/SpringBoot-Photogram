package com.cos.photogram.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.domain.image.Image;
import com.cos.photogram.domain.image.ImageRepository;
import com.cos.photogram.domain.subscribe.SubscribeRepository;
import com.cos.photogram.web.NotificationController;
import com.cos.photogram.web.dto.image.ImageUploadDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {

	private final ImageRepository imageRepository;
	private final SubscribeRepository subscribeRepository;
	
	/* 이미지 업로드 폴더 */
	@Value("${file.path}")
	private String uploadFolder;
	
	/* 검색 */
	public List<Image> imageSearch(String keyword) {
		return imageRepository.findByHashtagContaining(keyword);
	}
	
	/* 이미지 업로드 */
	@Transactional
	public void upload(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {
		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();
		Path imageFilePath = Paths.get(uploadFolder + imageFileName);
		
		try {
			Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Image image = imageUploadDto.toEntity(principalDetails.getUser(), imageFileName);
		imageRepository.save(image);
				
		/* 알림 부분 */
		List<Long> subsToList = subscribeRepository.findSubscribeTo(principalDetails.getUser().getId());
		for (Long id : subsToList) {
			SseEmitter sseEmitter = NotificationController.sseEmitters.get(id);
	        try {
	            sseEmitter.send(SseEmitter.event().name("notification").data("알림이 왔습니다."));
	        } catch (Exception e) {
	        	NotificationController.sseEmitters.remove(id);
	        }
		}
	}
	
	/* 스토리 페이지 */
	@Transactional(readOnly = true)
	public Page<Image> story(Long principalId, Pageable pageable) {
		Page<Image> images = imageRepository.story(principalId, pageable);
		
		images.forEach((image) -> {
			image.setLikesCount(image.getLikes().size());
			image.getLikes().forEach((like) -> {
				if(like.getUser().getId() == principalId)
					image.setLikesState(true);
			});
			image.setHashtagList(Arrays.asList(image.getHashtag().split(",")));
		});
		
		return images;
	}
	
	/* 인기 페이지 */
	@Transactional(readOnly = true)
	public List<Image> popular() {
		return imageRepository.popular();
	}
}
