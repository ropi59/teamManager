package fr.ropi.spring.teamsmanager.persons;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository <Person, String> {
}
