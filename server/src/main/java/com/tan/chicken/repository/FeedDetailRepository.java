package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tan.chicken.domain.FeedDetail;
@RepositoryRestResource
public interface FeedDetailRepository extends JpaRepository<FeedDetail, Long>{
	
	public Optional<FeedDetail> findById(Long id);
	
}
