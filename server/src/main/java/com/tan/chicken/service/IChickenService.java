package com.tan.chicken.service;

import java.util.List;
import java.util.Optional;

import com.tan.chicken.domain.Chicken;
public interface IChickenService {
	public List<Chicken> getChickens();
	public Optional<Chicken> getChicken(Long id);
	public Chicken saveChicken(Chicken chicken);
}
