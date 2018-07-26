package com.tan.chicken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tan.chicken.domain.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);
    Optional<Role> findByName(String name);
}