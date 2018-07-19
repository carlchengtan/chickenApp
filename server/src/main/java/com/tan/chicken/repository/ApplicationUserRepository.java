package com.tan.chicken.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tan.chicken.domain.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}