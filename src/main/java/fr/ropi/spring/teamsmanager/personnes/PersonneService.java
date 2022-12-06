package fr.ropi.spring.teamsmanager.personnes;

import fr.ropi.spring.teamsmanager.personnes.dtos.PersonneMinimumDTO;

import java.util.List;

public interface PersonneService {
    List<PersonneMinimumDTO> findAll(int page, int size);

    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);

    Personne updateSkill(String id, String idCompetence, int niveauCompetence);

    void deleteSkillById(String id, String idCompetence);

    List<Personne> getAllPersonsByLevelSupTo(String idCompetence, int level);
}
