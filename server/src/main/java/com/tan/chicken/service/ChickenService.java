package com.tan.chicken.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.domain.Owner;
import com.tan.chicken.repository.ChickenRepository;
import com.tan.chicken.repository.OwnerRepository;

@Component
public class ChickenService implements IChickenService{

	@Autowired
	private ChickenRepository chickenRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
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
	public void changeOwner(Long chickenId, Long ownerId) {
		Chicken chicken = chickenRepository.findById(chickenId).get();
		Owner owner = ownerRepository.findById(ownerId).get();
		chicken.changeOwner(owner);
	}

	
}
