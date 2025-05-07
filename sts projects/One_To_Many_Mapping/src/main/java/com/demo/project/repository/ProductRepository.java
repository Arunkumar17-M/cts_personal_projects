package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
