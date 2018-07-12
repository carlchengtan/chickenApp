package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tan.chicken.domain.Sickness;

public interface SicknessRepository extends JpaRepository<Sickness, Long>{
	
	public Optional<Sickness> findById(Long id);
	
}
