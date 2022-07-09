package com.cos.photogram.handler.ex;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException {

	//객체 구분에 사용
	private static final long serialVersionUID = 1L;

	private Map<String, String> erorrMap;
	
	public CustomValidationApiException(String message) {
		super(message);
	}
	
	public CustomValidationApiException(String message, Map<String, String> erorrMap) {
		super(message);
		this.erorrMap = erorrMap;
	}

	public Map<String, String> getErorrMap() {
		return erorrMap;
	}
}
