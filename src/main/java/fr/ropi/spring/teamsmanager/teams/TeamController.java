package fr.ropi.spring.teamsmanager.teams;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @PostMapping("")
    public Team save(@RequestBody Team entity) {
        return teamService.save(entity);
    }

    @GetMapping("{id}")
    public Team findById(@PathVariable String id) {
        return teamService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        teamService.deleteById(id);
    }
}
