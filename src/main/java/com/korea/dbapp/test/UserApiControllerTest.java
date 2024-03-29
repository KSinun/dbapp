package com.korea.dbapp.test;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;

@RestController
public class UserApiControllerTest {

	private final UserRepository userRepository;
	
	// 의존성 주입 (DI)
	public UserApiControllerTest(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// 프로토콜은 안지켜도됨 하지만 인터페이스는 지켜야함 (약속)
	// 테이블 명만 적어주면 자동으로 인서트해줌
	@PostMapping("/test/user")
	public String save(User user) {
		userRepository.save(user);
		return "save ok";
	}
	
	@GetMapping("/test/user")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	// http://localhost:8000/user/2
	@GetMapping("/test/user/{id}")
	public User findById(@PathVariable int id) {
		return userRepository.findById(id).get();
	}
	
	@GetMapping("/test/user/username/{username}")
	public User findByUsername(@PathVariable String username) {
		return userRepository.mFindByUsername(username);
	}
	
	@PostMapping("/test/login")
	public String login(String username, String password) {
		
		User user = userRepository.mLogin(username, password);
		if(user == null) {
			return "login fail";
		}else {
			return "login success";
		}
	}
	
	@DeleteMapping("/test/user/{id}")
	public String deleteByid(@PathVariable int id) {
		userRepository.deleteById(id);
		return "delete ok";
	}
	
	@PutMapping("/test/user/{id}")
	public String updateOne(@PathVariable int id, User user) { // password, email
		// 1. id로 select 하기, Entity = db에서 들고온 데이터
		User userEntity = userRepository.findById(id).get();
		// 2. 받은 body 데이터로 수정하기
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		// 3. save하면 된다. (이때 꼭 id 값이 db에 존재해야 update가 된다)
		userRepository.save(userEntity);
		
		return "update ok";
	}
	
}




