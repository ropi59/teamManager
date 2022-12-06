package fr.ropi.spring.teamsmanager.competences;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository repository;

    public CompetenceServiceImpl(CompetenceRepository repository) {
        this.repository = repository;
    }

    public List<Competence> findAll() {
        return repository.findAll();
    }

    public Competence save(Competence entity) {
        entity.setDateModification(LocalDateTime.now());
        return repository.save(entity);
    }

    public Competence findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
