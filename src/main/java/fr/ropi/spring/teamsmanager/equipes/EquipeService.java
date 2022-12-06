package fr.ropi.spring.teamsmanager.equipes;

import fr.ropi.spring.teamsmanager.personnes.dtos.PersonneMeilleurCompDTO;

import java.util.List;

public interface EquipeService {

    List<Equipe> findAll();

    Equipe save(Equipe entity);

    Equipe findById(String id);

    void deleteById(String id);

    /**
     * Ajoute un membre via son id à une équipe définie par son id
     * @param idEquipe id de l'équipe à modifier
     * @param idMembre id du membre à ajouter
     * @return l'équipe mise à jour
     */
    Equipe ajoutMembre(String idEquipe, String idMembre);

    /**
     * Retire un membre via son id d'une équipe définie par son id
     * @param idEquipe id de l'équipe à modifier
     * @param idMembre id du membre à ajouter
     * @return l'équipe mise à jour
     */
    Equipe retraitMembre(String idEquipe, String idMembre);

    List<PersonneMeilleurCompDTO> bestSkillByTeamMember(String idEquipe);
}
