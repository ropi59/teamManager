package fr.ropi.spring.teamsmanager.equipes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipeRepository extends MongoRepository<Equipe, String> {
}
