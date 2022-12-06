package fr.ropi.spring.teamsmanager.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ropi.spring.teamsmanager.competences.Competence;
import fr.ropi.spring.teamsmanager.competences.CompetenceService;
import fr.ropi.spring.teamsmanager.equipes.EquipeServiceImpl;
import fr.ropi.spring.teamsmanager.personnes.dtos.PersonneMinimumDTO;
import fr.ropi.spring.teamsmanager.personnes.repositories.PersonneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonneServiceImpl implements PersonneService {

    private static final Logger logger = LoggerFactory.getLogger(EquipeServiceImpl.class);

    private final PersonneRepository repository;
    private final CompetenceService competenceService;
    private final ObjectMapper mapper;

    public PersonneServiceImpl(PersonneRepository repository, ObjectMapper mapper, CompetenceService competenceService) {
        this.repository = repository;
        this.mapper = mapper;
        this.competenceService = competenceService;
    }

    @Override
    public List<PersonneMinimumDTO> findAll(int page, int size) {
        List<Personne> personsList = repository.findAll(PageRequest.of(page, size)).toList();;
        List<PersonneMinimumDTO> minimalPersonsList = new ArrayList<>();
        for (Personne person: personsList){
            minimalPersonsList.add(this.mapper.convertValue(person, PersonneMinimumDTO.class));
        }
        return minimalPersonsList;
    }

    @Override
    public Personne save(Personne entity) {
        entity.setDateModification(LocalDateTime.now());
        return repository.save(entity);
    }

    @Override
    public Personne findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("ID invalide " + id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * Methode pour mettre à jour ou ajouter une compétence à une personne
     * @param id id de la personne
     * @param idCompetence id de la competence à modifier
     * @param niveau niveau de la personne dans la competence
     */
    @Override
    public Personne updateSkill(String id, String idCompetence, int niveau) {
        Personne personne = DeleteSkillLevelById(id, idCompetence);
        personne.getCompetences().add(new NiveauCompetence(new Competence(idCompetence), niveau));

        return this.save(personne);
    }


    /**
     * Methode pour supprimer une compétence d'une personne
     * @param id id de la personne
     * @param idCompetence id de la competence à supprimer
     */
    @Override
    public void deleteSkillById(String id, String idCompetence) {
        Personne personne = DeleteSkillLevelById(id, idCompetence);
        this.repository.save(personne);
    }

    /**
     * Methode pour supprimer un niveau de compétence d'un utilisateur par id
     * @param id l'id de la personne
     * @param idCompetence id de la competence
     * @return la personne avec sa compétence retirée.
     */
    private Personne DeleteSkillLevelById(String id, String idCompetence) {
        //récupération de la personne à qui modifier une competence
        Personne personne = this.findById(id);
        //recuperation de la competence
        Competence competence = this.competenceService.findById(idCompetence);
        //récupération de toutes ses compétences
        List<NiveauCompetence> niveauCompetences = personne.getCompetences();

        niveauCompetences.removeIf(niveauCompetence -> niveauCompetence.getCompetence().equals(competence));
        return personne;
    }

    /**
     * Methode pour trouver toutes les personnes ayant un niveau minimum dans une compétence particulière
     * @param idCompetence la compétence à trouver
     * @param level le niveau minimum de la compétence à avoir
     * @return liste des personnes ayant un certain niveau dans une competence particulière.
     */
    @Override
    public List<Personne> getAllPersonsByLevelSupTo(String idCompetence, int level) {
        List<Personne> personnes = this.repository.findAllByCompetencesCompetenceId(idCompetence);
        return personnes.stream().filter(personne -> {
            return personne.getCompetences().stream().anyMatch(niveauCompetence -> {
                return niveauCompetence.getCompetence().getId().equals(idCompetence)
                        && niveauCompetence.getNiveau() >= level;
            });
        }).toList();
    }

}
