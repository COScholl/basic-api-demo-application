package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.dao.PersonDao;

/*
    The @Service annotation indicates business logic happens here.
    The service references the interface PersonDao
 */
@Service
public class PersonService {
    /*
        get the interface for PersonDao, not concrete Class
        we will use FakePersonDataAccessService to demonstrate
        dependency injection
     */
    private final PersonDao personDao;

    /*
        @Autowired indicates that we are injecting functionality
        into the bean via the constructor.
        In this case, we are injecting into PersonDao class,
        but since there can me more than one instance of PersonDao
        as a bean, and we will need to qualify which instance we are
        dealing with. @Qualifier is used here, and we can add properties
        as well with @Qualifier
     */
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {

        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

}
