package com.soft.infg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soft.infg.model.Person;
import com.soft.infg.service.PersonCounterRepos;




@RestController
@RequestMapping("/person")
public class PersonController {

	
	
	@Autowired
	PersonCounterRepos repos;
	
	@GetMapping
	public List<Person> findAll() {
		return repos.findAll();
	}
	
	@GetMapping("/{id}")
	public Person findById(@RequestParam("id") Long id) {
		return repos.findOne(id);
	}
	
	@PostMapping
	public Person add(@RequestBody Person p) {
		
		repos.save(p);
		return p;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@RequestParam("id") Long id) {
		
		repos.delete(id);
	}
	
	
	
}
