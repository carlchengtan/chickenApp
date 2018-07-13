package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tan.chicken.domain.Owner;
@RepositoryRestResource
public interface OwnerRepository extends JpaRepository<Owner, Long>{
	
	public Optional<Owner> findById(Long id);
	
}
