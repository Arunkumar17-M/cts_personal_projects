package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

	Login findByUsername(String username);
}
