package com.example.demo.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;


/*
    @RequestMapping - This annotation is used to implement the URL handler typical of MVC projects.
    @RestController -This annotation is used to make every method of the class
    return a domain object
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;
    /*
        Inject the service logic into controller constructor (?)
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    /*
        @PostMapping handle POST request method. Can take url blob ("/post")
        and the like
        @RequestBody maps HttpRequest body to a transfer domain or object
        here we are mapping the request to the Person object
     */
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {

        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    /*
        this mapping is a subset of @RequestMapping at the top
        of the class definition, so {id} is actually api/v1/person/{id}
     */
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {

        personService.updatePerson(id, personToUpdate);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id) {

        personService.deletePerson(id);
    }
}
