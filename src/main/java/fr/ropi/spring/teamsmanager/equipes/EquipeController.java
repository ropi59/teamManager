package fr.ropi.spring.teamsmanager.equipes;

import fr.ropi.spring.teamsmanager.personnes.dtos.PersonneMeilleurCompDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping("")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    @PostMapping("")
    public Equipe save(@RequestBody Equipe entity) {
        return equipeService.save(entity);
    }

    @GetMapping("{id}")
    public Equipe findById(@PathVariable String id) {
        return equipeService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        equipeService.deleteById(id);
    }

    @PutMapping("{idEquipe}/membres/{idMembre}")
    public Equipe ajoutMembre(@PathVariable String idEquipe,
                              @PathVariable String idMembre){
        return this.equipeService.ajoutMembre(idEquipe, idMembre);
    }

    @DeleteMapping("{idEquipe}/membres/{idMembre}")
    public Equipe retraitMembre(@PathVariable String idEquipe,
                              @PathVariable String idMembre){
        return this.equipeService.retraitMembre(idEquipe, idMembre);
    }

    @GetMapping("{idEquipe}/membres/competences")
    public List<PersonneMeilleurCompDTO> bestSkillByTeamMember(@PathVariable String idEquipe){
        return this.equipeService.bestSkillByTeamMember(idEquipe);
    }
}
