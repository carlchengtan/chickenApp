package com.tan.chicken.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.exception.ChickenNotFoundException;
import com.tan.chicken.service.ChickenService;

@RestController
public class ChickenController {

	@Autowired
	private ChickenService chickenService;
	
	@GetMapping
	public String test() {
		return "Hello";
	}
	
	@ResponseBody
	@GetMapping("/chickens")
	public List<Chicken> retrieveAllChickens() {
		return chickenService.findAll();
	}

	@GetMapping("/chickens/{id}")
	public Chicken retrieveChicken(@PathVariable long id) {
		Optional<Chicken> chicken = chickenService.findById(id);

		if (!chicken.isPresent())
			try {
				throw new ChickenNotFoundException("id-" + id);
			} catch (ChickenNotFoundException e) {
				e.printStackTrace();
			}

		return chicken.get();
	}

	@DeleteMapping("/chickens/{id}")
	public void deleteChicken(@PathVariable long id) {
		chickenService.deleteById(id);
	}

	@PostMapping("/chickens")
	public Chicken createChicken(@RequestBody Chicken chicken) {
		return chickenService.save(chicken);
	}
	
	@PutMapping("/chickens/{id}")
	public Chicken updateChicken(@PathVariable Long id, @RequestBody Chicken chicken) {
		return chickenService.save(chicken);
	}
	
	@PutMapping("/chickens/{chickenId}/{ownerId}")
	public void changeOwner(@PathVariable Long chickenId, @PathVariable Long userId) {
		chickenService.changeApplicationUser(chickenId, userId);
	}
	
}
