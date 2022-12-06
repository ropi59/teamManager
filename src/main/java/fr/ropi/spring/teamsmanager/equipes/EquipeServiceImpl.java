package fr.ropi.spring.teamsmanager.equipes;

import fr.ropi.spring.teamsmanager.personnes.NiveauCompetence;
import fr.ropi.spring.teamsmanager.personnes.Personne;
import fr.ropi.spring.teamsmanager.personnes.PersonneService;
import fr.ropi.spring.teamsmanager.personnes.dtos.PersonneMeilleurCompDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipeServiceImpl implements EquipeService {

    private static final Logger logger = LoggerFactory.getLogger(EquipeServiceImpl.class);
    private final EquipeRepository repository;
    private final PersonneService personneService;

    public EquipeServiceImpl(EquipeRepository repository, PersonneService personneService) {
        this.repository = repository;
        this.personneService = personneService;
    }

    public List<Equipe> findAll() {
        return repository.findAll();
    }

    public Equipe save(Equipe entity) {
        for (Personne membre : entity.getMembres()){
            if (membre.getId() == null){
                this.personneService.save(membre);
            }
        }
        entity.setDateModification(LocalDateTime.now());
        logger.info("Sauvegarde d'une nouvelle équipe: " + entity);
        return repository.save(entity);
    }

    public Equipe findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("ID invalide " + id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * Ajoute un membre via son id à une équipe définie par son id
     *
     * @param idEquipe id de l'équipe à modifier
     * @param idMembre id du membre à ajouter
     * @return l'équipe mise à jour
     */
    @Override
    public Equipe ajoutMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membreAAjouter = this.personneService.findById(idMembre);
        if(equipe.getMembres().stream().noneMatch(equipeMembre -> equipeMembre.getId().equals(idMembre))){
            equipe.getMembres().add(membreAAjouter);
        }
        logger.info("Ajout d'un nouveau membre à l'équipe: " + equipe);
        return this.save(equipe);
    }

    /**
     * Retire un membre via son id d'une équipe définie par son id
     *
     * @param idEquipe id de l'équipe à modifier
     * @param idMembre id du membre à ajouter
     * @return l'équipe mise à jour
     */
    @Override
    public Equipe retraitMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        for (Personne membre: equipe.getMembres()) {
            if (membre.getId().equals(idMembre)){
                equipe.getMembres().remove(membre);
                break;
            }
        }
        return this.save(equipe);
    }

    /**
     * Methode pour afficher la meilleure compétence de chaque membre d'une équipe
     * @param idEquipe l'id de l'équipe à verifier
     * @return une équipe avec des personnes personnalisées (PersonneMeilleurCompDTO)
     */
    @Override
    public List<PersonneMeilleurCompDTO> bestSkillByTeamMember(String idEquipe) {
        Equipe equipe = this.findById(idEquipe);
        List<PersonneMeilleurCompDTO> equipeDetails = new ArrayList<>();
        for (Personne membre: equipe.getMembres()){
            Optional<NiveauCompetence> niveauCompetence = membre.getCompetences().stream().reduce((comp1, comp2) ->{
                return comp1.getNiveau() > comp2.getNiveau()? comp1: comp2;
            });
            List<NiveauCompetence> niveauCompetences = new ArrayList<>();
            if (niveauCompetence.isPresent()){
                niveauCompetences.add(niveauCompetence.get());
            }
            equipeDetails.add(new PersonneMeilleurCompDTO(
                    membre.getId(),
                    membre.getNom(),
                    membre.getPrenom(),
                    niveauCompetence.get()
            ));
        }
        return equipeDetails;
    }

}
