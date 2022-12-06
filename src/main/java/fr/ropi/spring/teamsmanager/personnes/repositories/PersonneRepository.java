package fr.ropi.spring.teamsmanager.personnes.repositories;

import fr.ropi.spring.teamsmanager.personnes.Personne;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonneRepository extends MongoRepository <Personne, String>, CustomPersonneRepository {

    List<Personne> findAllByCompetencesCompetenceId(String idCompetence);
}
