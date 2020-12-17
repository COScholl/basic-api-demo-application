package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.model.Person;

/**
 * Define operations allowed for contract to implement this interface
 * We will use dependency injection to change implementations using this
 */
public interface PersonDao {
    // mock db using a list, will use this method
    // this insert will return 0 or 1
    int insertPerson(UUID id, Person person);
    // this method will generate the UUID and call insertPerson with that id
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();

        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    int deletePersonById(UUID id);
}
