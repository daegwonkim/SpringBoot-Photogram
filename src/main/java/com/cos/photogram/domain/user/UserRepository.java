package com.cos.photogram.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	List<User> findByNameContaining(String keyword);
}
