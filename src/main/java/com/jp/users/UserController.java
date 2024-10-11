package com.jp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity userEntity) {
		UserEntity savedEntity = userRepository.save(userEntity);
		return savedEntity;
	}

	@GetMapping("/{Id}")
	public UserEntity getUser(@PathVariable Integer Id) {
		return userRepository.findById(Id).orElse(null);
	}

}
