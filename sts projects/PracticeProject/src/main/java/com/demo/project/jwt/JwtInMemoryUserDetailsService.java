package com.demo.project.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.project.jwt.resource.JwtTokenRequest;
import com.demo.project.model.Login;
import com.demo.project.repository.LoginRepository;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Login user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new JwtUserDetails((long) user.getId(), user.getUsername(), user.getPassword(), user.getUsername());
	}

	public Login save(JwtTokenRequest user) {
		Login newUser = new Login();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}

}