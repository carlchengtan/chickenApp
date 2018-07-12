package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tan.chicken.domain.FeedDetail;

public interface FeedDetailRepository extends JpaRepository<FeedDetail, Long>{
	
	public Optional<FeedDetail> findById(Long id);
	
}
