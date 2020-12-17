package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;
/*
    @Repository marks Java classes that directly access the database and
    marks classes that fulfill the role of Data Access Object.
 */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();
    /*
        this method `insertPerson()` redefines the method
        `insertPerson()` defined in PersonDao
    */
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));

        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {

        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(personObj -> {
                    int indexOfPersonToUpdate = DB.indexOf(personObj);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));

                        return 1;
                    }

                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (!personMaybe.isPresent()) {

            return 0;
        }
        DB.remove(personMaybe.get());

        return 1;
    }

}
