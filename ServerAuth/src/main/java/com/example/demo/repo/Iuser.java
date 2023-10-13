package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface Iuser extends JpaRepository<User, Long>{
		public User findByUsername(String username);
}
