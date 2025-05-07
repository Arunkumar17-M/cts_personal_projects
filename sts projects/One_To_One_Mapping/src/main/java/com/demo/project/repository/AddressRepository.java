package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
