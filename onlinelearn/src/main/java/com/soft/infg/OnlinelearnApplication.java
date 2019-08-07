package com.soft.infg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soft.infg.model.Gender;
import com.soft.infg.model.Person;
import com.soft.infg.service.PersonCounterRepos;

@SpringBootApplication
public class OnlinelearnApplication  implements CommandLineRunner {


	@Autowired
	PersonCounterRepos repos;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlinelearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repos.save(new Person("Amit", "Kumar", 23, Gender.MALE));
		repos.save(new Person("Sumit", "Kumar", 25, Gender.MALE));
		repos.save(new Person("Dev", "Kumar", 31, Gender.MALE));
		repos.save(new Person("Reena", "Singh", 23, Gender.FEMALE));
		repos.save(new Person("Shweta", "Singh", 19, Gender.FEMALE));
		
		repos.findAll().forEach(System.out::println);
	}

}
