package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tan.chicken.domain.Chicken;
@RepositoryRestResource
public interface ChickenRepository extends JpaRepository<Chicken, Long>{

	Optional<Chicken> findByRfid(String rfid);
	
}
