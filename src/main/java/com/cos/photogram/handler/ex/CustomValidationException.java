package com.cos.photogram.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException {

	//객체 구분에 사용
	private static final long serialVersionUID = 1L;

	private Map<String, String> erorrMap;
	
	public CustomValidationException(String message, Map<String, String> erorrMap) {
		super(message);
		this.erorrMap = erorrMap;
	}

	public Map<String, String> getErorrMap() {
		return erorrMap;
	}
}
