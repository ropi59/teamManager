package fr.ropi.spring.teamsmanager.competences;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetenceRepository extends MongoRepository <Competence, String> {
}
