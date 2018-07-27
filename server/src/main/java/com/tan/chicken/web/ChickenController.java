package com.tan.chicken.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.tan.chicken.service.ChickenServiceImpl;

@RestController
public class ChickenController {
	
	@Autowired
	private ChickenServiceImpl chickenService;
	
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
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/chickens/{id}")
	public void deleteChicken(@PathVariable long id) {
		chickenService.deleteById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/chickens")
	public Chicken createChicken(@RequestBody Chicken chicken) {
		return chickenService.save(chicken);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/chickens/{id}")
	public Chicken updateChicken(@PathVariable Long id, @RequestBody Chicken chicken) {
		chicken.setId(id);
		return chickenService.save(chicken);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/chickens/{chickenId}/{ownerId}")
	public Chicken changeOwner(@PathVariable Long chickenId, @PathVariable Long ownerId) {
		System.out.println("#################"+chickenId+ownerId);
		return chickenService.changeOwner(chickenId, ownerId);
	}
	
}
