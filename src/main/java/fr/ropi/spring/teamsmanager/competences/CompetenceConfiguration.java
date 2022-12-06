package fr.ropi.spring.teamsmanager.competences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompetenceConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(CompetenceConfiguration.class);
    @Bean
    public CompetenceService skillService (CompetenceRepository competenceRepository){
        logger.info("Création du bean CompetenceService");
        return new CompetenceServiceImpl(competenceRepository);
    }
}
