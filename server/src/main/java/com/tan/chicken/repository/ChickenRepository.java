package com.tan.chicken.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tan.chicken.domain.Chicken;

public interface ChickenRepository extends JpaRepository<Chicken, Long>{
	
}
