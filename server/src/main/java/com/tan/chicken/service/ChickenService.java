package com.tan.chicken.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.repository.ChickenRepository;

@Component
public class ChickenService implements IChickenService{

	@Autowired
	private ChickenRepository chickenRepository;
	
	@Override
	public List<Chicken> getChickens() {
		return chickenRepository.findAll();
	}

	@Override
	public Optional<Chicken> getChicken(Long id) {
		return chickenRepository.findById(id);
	}

	@Override
	public Chicken saveChicken(Chicken chicken) {
		return chickenRepository.save(chicken);
		
	}
	
}
