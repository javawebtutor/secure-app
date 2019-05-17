package com.jwt.secure.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.secure.app.entity.User;
import com.jwt.secure.app.model.UserPrincipal;
import com.jwt.secure.app.repo.UserRepository;

@Service
public class AppUserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if(user == null) {
			throw new UsernameNotFoundException("User not Found in DB");
		}
				
		return new UserPrincipal(user);
	}

}
