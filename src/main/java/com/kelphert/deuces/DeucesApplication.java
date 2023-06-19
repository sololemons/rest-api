package com.kelphert.deuces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class DeucesApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(DeucesApplication.class, args);
	}

	private PersonRepository personRepository;

	@Autowired

	public DeucesApplication(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void run(String... args) throws Exception {

	Person person=new Person();
person.setId(1);
	person.setFirst_name("joshua");
	person.setLast_name("Kimmich");
	person.setAge(20);
	person.setState("Orlando");
	personRepository.save(person);


		Person person2=new Person();
person.setId(2);
		person.setFirst_name("joshua");
		person.setLast_name("Kimmich");
		person.setAge(20);
		person.setState("Orlando");
		personRepository.save(person);



		Person person3=new Person();
person.setId(3);
		person.setFirst_name("howard");
		person.setLast_name("Debuchy");
		person.setAge(18);
		person.setState("Florida");
		personRepository.save(person);






	}
}


