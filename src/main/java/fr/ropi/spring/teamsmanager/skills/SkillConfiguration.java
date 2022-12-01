package fr.ropi.spring.teamsmanager.skills;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SkillConfiguration {

    @Bean
    public SkillService skillService (SkillRepository skillRepository){
        return new SkillServiceImpl(skillRepository);
    }
}
