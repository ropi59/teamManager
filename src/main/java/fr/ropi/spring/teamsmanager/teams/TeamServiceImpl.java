package fr.ropi.spring.teamsmanager.teams;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class TeamServiceImpl implements TeamService{
    private final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    public Team save(Team entity) {
        return repository.save(entity);
    }

    public Team findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
