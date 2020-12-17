//package com.example.demo.dao;
//
//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.model.Person;
//
//// for every *AccessService.java where @Repository("<repo name>"),
//// change @Qualifier("<repo name>") in PersonService.java to hook up
//// the *AccessService DB functionality
//@Repository("postgres")
//public class PersonDataAccessService implements PersonDao {
//    @Override
//    public int insertPerson(UUID id, Person person) {
//
//        return 0;
//    }
//
//    @Override
//    public List<Person> selectAllPeople() {
//        List<Person> personList = new ArrayList<Person>();
//        personList.add(new Person(UUID.randomUUID(), "FROM POSTGRESS DB"));
//        return (List<Person>) personList;
//    }
//
//    @Override
//    public Optional<Person> selectPersonById(UUID id) {
//
//        return Optional.empty();
//    }
//
//    @Override
//    public int updatePersonById(UUID id, Person person) {
//
//        return 0;
//    }
//
//    @Override
//    public int deletePersonById(UUID id) {
//
//        return 0;
//    }
//}
