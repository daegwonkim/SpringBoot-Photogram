package com.cos.photogram.web;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.cos.photogram.config.auth.PrincipalDetails;
import com.cos.photogram.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NotificationController {
	
	private final NotificationService notificationService; 
	
	public static Map<Long, SseEmitter> sseEmitters = new ConcurrentHashMap<>();
	
	@GetMapping(value = "/sub", produces = "text/event-stream")
	public SseEmitter subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails,
			@RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") String lastEventId) {
		
		Long userId = principalDetails.getUser().getId();
		
		SseEmitter sseEmitter = notificationService.subscribe(userId);
		
		return sseEmitter;
	}
}
