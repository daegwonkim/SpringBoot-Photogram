package com.cos.photogram.web.dto.subscribe;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubscribeDto {

	private BigInteger id;
	private String username;
	private String profile_image_url;
	private Integer subscribe_state;
	private Integer equal_user_state;
}
