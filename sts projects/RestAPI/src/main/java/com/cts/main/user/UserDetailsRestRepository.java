package com.cts.main.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

	public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long> {

	List<UserDetails> findByRole(String role);
}
