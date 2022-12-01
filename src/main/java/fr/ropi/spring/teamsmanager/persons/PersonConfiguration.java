package fr.ropi.spring.teamsmanager.persons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {

    @Bean
    public PersonService personService(PersonRepository personRepository){
        return new PersonServiceImpl(personRepository);
    }
}
