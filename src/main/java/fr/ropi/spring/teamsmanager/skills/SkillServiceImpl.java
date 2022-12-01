package fr.ropi.spring.teamsmanager.skills;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    public List<Skill> findAll() {
        return repository.findAll();
    }

    public Skill save(Skill entity) {
        return repository.save(entity);
    }

    public Skill findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
