package fr.ropi.spring.teamsmanager.persons;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person save(Person entity);

    Person findById(String id);

    void deleteById(String id);
}
