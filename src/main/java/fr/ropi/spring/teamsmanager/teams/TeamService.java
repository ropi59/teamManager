package fr.ropi.spring.teamsmanager.teams;

import fr.ropi.spring.teamsmanager.skills.Skill;

import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team save(Team entity);

    Team findById(String id);

    void deleteById(String id);
}
