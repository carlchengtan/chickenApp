package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tan.chicken.domain.Sickness;
@RepositoryRestResource
public interface SicknessRepository extends JpaRepository<Sickness, Long>{
	
	public Optional<Sickness> findById(Long id);
	
}
