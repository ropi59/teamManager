package fr.ropi.spring.teamsmanager.equipes;

import fr.ropi.spring.teamsmanager.personnes.PersonneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EquipeConfiguration {

    //LOGGER !!! slf4j
    private static final Logger logger = LoggerFactory.getLogger(EquipeConfiguration.class);

    @Bean
    public EquipeService teamService (EquipeRepository equipeRepository, PersonneService personneService){
        logger.info("Création du bean EquipeService");
        return new EquipeServiceImpl(equipeRepository, personneService);
    }
}
