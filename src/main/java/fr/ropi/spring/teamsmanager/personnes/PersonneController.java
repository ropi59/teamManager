package fr.ropi.spring.teamsmanager.personnes;

import fr.ropi.spring.teamsmanager.personnes.dtos.PersonneMinimumDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("")
    public List<PersonneMinimumDTO> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return personneService.findAll(page, size);
    }

    @PostMapping("")
    public Personne save(@RequestBody Personne entity) {
        return personneService.save(entity);
    }

    @GetMapping("{id}")
    public Personne findById(@PathVariable String id) {
        return personneService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        personneService.deleteById(id);
    }

    @PostMapping("{id}/competences/{idCompetence}")
    public Personne updateSkill(@PathVariable String id,
                            @PathVariable String idCompetence,
                            @RequestParam int niveauCompetence) {
        return personneService.updateSkill(id, idCompetence, niveauCompetence);
    }

    @DeleteMapping("{id}/competences/{idCompetence}")
    public void deleteSkillById(@PathVariable String id,
                                @PathVariable String idCompetence) {
        personneService.deleteSkillById(id, idCompetence);
    }

    @GetMapping("/competences/{idCompetence}")
    public List<Personne> getAllPersonsByLevelSupTo(@PathVariable String idCompetence,
                                                    @RequestParam int level){
        return personneService.getAllPersonsByLevelSupTo(idCompetence, level);
    }
}
