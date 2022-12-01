package fr.ropi.spring.teamsmanager.skills;

import java.util.List;

public interface SkillService {

    List<Skill> findAll();

    Skill save(Skill entity);

    Skill findById(String id);

    void deleteById(String id);
}
