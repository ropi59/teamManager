package fr.ropi.spring.teamsmanager.utils;

import fr.ropi.spring.teamsmanager.competences.Competence;
import fr.ropi.spring.teamsmanager.competences.CompetenceRepository;
import fr.ropi.spring.teamsmanager.equipes.EquipeRepository;
import fr.ropi.spring.teamsmanager.personnes.repositories.PersonneRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("debug")
@Profile("dev")
public class DebugController {

    private final CompetenceRepository competenceRepository;
    private final PersonneRepository personneRepository;
    private final EquipeRepository equipeRepository;

    public DebugController(CompetenceRepository competenceRepository, PersonneRepository personneRepository, EquipeRepository equipeRepository) {
        this.competenceRepository = competenceRepository;
        this.personneRepository = personneRepository;
        this.equipeRepository = equipeRepository;
    }

    @DeleteMapping("clear")
    public void clear() {
        competenceRepository.deleteAll();
        personneRepository.deleteAll();
        equipeRepository.deleteAll();
    }

    @PostMapping("init")
    public void init(){
        clear();
        Competence java = new Competence("Java", "Langage back-end orienté objet");
        Competence angular = new Competence("Angular", "Framework front-end orienté composants");
    }
}
