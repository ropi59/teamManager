package fr.ropi.spring.teamsmanager.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ropi.spring.teamsmanager.competences.CompetenceService;
import fr.ropi.spring.teamsmanager.personnes.repositories.PersonneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonneConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(PersonneConfiguration.class);

    @Bean
    public PersonneService personService(PersonneRepository personneRepository, ObjectMapper mapper, CompetenceService competenceService){
        logger.info("Création du bean PersonneService");
        return new PersonneServiceImpl(personneRepository, mapper, competenceService);
    }
}
