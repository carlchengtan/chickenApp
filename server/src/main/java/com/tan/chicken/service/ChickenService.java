package com.tan.chicken.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.domain.ApplicationUser;
import com.tan.chicken.repository.ChickenRepository;
import com.tan.chicken.repository.ApplicationUserRepository;

@Component
public class ChickenService implements IChickenService{

	@Autowired
	private ChickenRepository chickenRepository;
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
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
	public void changeApplicationUser(Long chickenId, Long applicationUserId) {
		Chicken chicken = chickenRepository.findById(chickenId).get();
		ApplicationUser applicationUser = applicationUserRepository.findById(applicationUserId).get();
		chicken.changeApplicationUser(applicationUser);
	}

	
}
