package com.tan.chicken.service;

import java.util.List;
import java.util.Optional;

import com.tan.chicken.domain.Chicken;
public interface IChickenService {
	public List<Chicken> findAll();
	public Optional<Chicken> findById(Long id);
	public Chicken save(Chicken chicken);
	public void deleteById(Long id);
	public Chicken changeOwner(Long chickenId, Long ownerId);
}
