package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tan.chicken.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>{
	
	public Optional<Owner> findById(Long id);
	
}
