package fr.ropi.spring.teamsmanager.skills;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkillRepository extends MongoRepository <Skill, String> {
}
