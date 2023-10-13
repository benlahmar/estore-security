package com.example.demo.security.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repo.Iuser;

@RestController
@RequestMapping("/auth")
public class Authentificate {

	@Autowired
	Iuser urepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/register")
	public User adduser(@RequestBody User u)
	{
		u.setPassword(encoder.encode(u.getPassword()));
		u=urepo.save(u);
		
		return u;
	}
	@GetMapping("/hi")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("/users")
	public List<User> users()
	{
		return urepo.findAll();
	}
}
