package com.tan.chicken.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.exception.ChickenNotFoundException;
import com.tan.chicken.service.ChickenService;

@RestController
public class ChickenController {

	@Autowired
	private ChickenService chickenService;
	
	@RequestMapping
	public String test() {
		return "Hello";
	}
	
	@RequestMapping(value="/chickens")
	public List<Chicken> getChickens() {
		return chickenService.getChickens();
	}
	
	@GetMapping("/chickens/{id}")
	public Chicken retrieveStudent(@PathVariable long id) {
		Optional<Chicken> chicken = chickenService.getChicken(id);
		try {
			if (!chicken.isPresent()) {
				throw new ChickenNotFoundException("id-" + id);	
			}
		} catch (ChickenNotFoundException e) {
//			log.debug("No chicken with the id " + e);
		}
		return chicken.get();
	}
	
//	Delete a student - @DeleteMapping(“/students/{id}”)
//	Create a new student - @PostMapping(“/students”)
//	Update student details - @PutMapping(“/students/{id}”)

}
