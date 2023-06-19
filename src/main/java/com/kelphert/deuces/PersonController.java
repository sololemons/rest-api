package com.kelphert.deuces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;



@RestController
@RequestMapping( path = "api/v1/person")

public class PersonController {

private PersonRepository personRepository;
@Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //view ALL People

    @GetMapping
    public List<Person>getPersons(){
    return personRepository.findAll();
    }


    //crate A new Person
    @PostMapping
    public Person createNewPerson(@RequestBody Person person){
return personRepository.save(person);

    }



    // build get person by id

    @GetMapping("{id}")
    public ResponseEntity<Person>getPersonbyid(@PathVariable Integer id){
    Person person=personRepository.findById(id).orElseThrow(()->new ResoureNotFoundException("Person does not exist with id :"+id));
    return ResponseEntity.ok(person);
    }


    //update Person
    @PutMapping("{id}")
    public ResponseEntity<Person>updatePerson(@PathVariable Integer id,@RequestBody Person personDetails){
    Person updatePerson=personRepository.findById(id).orElseThrow(()-> new ResoureNotFoundException("Person does not exsist in our database with id:"+id));

    updatePerson.setId(personDetails.getId());
    updatePerson.setFirst_name(personDetails.getFirst_name());
    updatePerson.setLast_name(personDetails.getLast_name());
    updatePerson.setState(personDetails.getState());
    updatePerson.setAge(personDetails.getAge());

    personRepository.save(updatePerson);
    return ResponseEntity.ok(updatePerson);

    }


    // delete person
    @DeleteMapping("{id}")
public ResponseEntity<HttpStatus>deletePerson(@PathVariable Integer id){
 Person person=personRepository.findById(id) .orElseThrow(() -> new ResoureNotFoundException("Person does not exsist in our database with Id :"+id));
 personRepository.delete(person);
 return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
