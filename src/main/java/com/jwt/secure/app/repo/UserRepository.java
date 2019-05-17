package com.jwt.secure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.secure.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}
