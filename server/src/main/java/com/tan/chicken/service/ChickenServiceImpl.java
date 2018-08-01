package com.tan.chicken.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.domain.User;
import com.tan.chicken.repository.ChickenRepository;
import com.tan.chicken.repository.UserRepository;

@Component
public class ChickenServiceImpl implements IChickenService{

	@Autowired
	private ChickenRepository chickenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Chicken> findAll() {
		return chickenRepository.findAll();
	}

	@Override
	public Optional<Chicken> findById(Long id) {
		return chickenRepository.findById(id);
	}

	@Override
	public Chicken save(Chicken chicken) {
		 return chickenRepository.save(chicken);
	}

	@Override
	public void deleteById(Long id) {
		chickenRepository.deleteById(id);
	}

	@Override
	public Chicken changeOwner(Long chickenId, Long ownerId) {
		Chicken chicken = chickenRepository.findById(chickenId).get();
		User owner = userRepository.findById(ownerId).get();
		return chickenRepository.save(chicken);
	}

	
}
