package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tan.chicken.domain.MedicalRecord;
@RepositoryRestResource
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>{
	
	public Optional<MedicalRecord> findById(Long id);
	
}
