package fr.ropi.spring.teamsmanager.teams;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamConfiguration {

    @Bean
    public TeamService teamService (TeamRepository teamRepository){
        return new TeamServiceImpl(teamRepository);
    }
}
