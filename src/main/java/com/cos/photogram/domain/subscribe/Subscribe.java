package com.cos.photogram.domain.subscribe;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cos.photogram.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(	//데이터베이스에서 두 개의 컬럼에 대해 unique 제약조건 설정 
	uniqueConstraints = {
		@UniqueConstraint(
			name = "subscribe_uk",
			columnNames = {"from_user_id", "to_user_id"}
		)
	}
)
@Entity
public class Subscribe {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User from_user;
	
	@ManyToOne
	private User to_user;
	
	private LocalDateTime create_date;
	
	@PrePersist
	public void createDate() {
		create_date = LocalDateTime.now(); 
	}
}