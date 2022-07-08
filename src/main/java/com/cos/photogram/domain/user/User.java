package com.cos.photogram.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 20, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String name;
	
	private String phone;
	
	private String gender;
	
	private String website;	//사용자 웹사이트
	
	private String bio;	//사용자 자기소개
	
	private String profileImageUrl;	//사용자 프로필 이미지 경로
	
	private String role;
	
	private LocalDateTime create_date;
	
	@PrePersist	//데이터베이스에 INSERT 되기 직전에 실행
	public void createDate() {
		this.create_date = LocalDateTime.now();
	}
}
