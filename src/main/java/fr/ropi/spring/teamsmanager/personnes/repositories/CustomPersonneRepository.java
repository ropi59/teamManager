package fr.ropi.spring.teamsmanager.personnes.repositories;

public interface CustomPersonneRepository {

    public void deleteCompetenceByCompetenceId(String idPersonne, String idCompetence);
}
