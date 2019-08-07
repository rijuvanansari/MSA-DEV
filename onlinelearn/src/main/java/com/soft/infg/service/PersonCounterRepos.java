package com.soft.infg.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.soft.infg.model.Person;

@Service
public  interface PersonCounterRepos extends JpaRepository<Person, Long> {

	
    
}
