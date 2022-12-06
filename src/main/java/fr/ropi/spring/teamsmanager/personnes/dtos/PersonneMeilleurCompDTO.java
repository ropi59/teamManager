package fr.ropi.spring.teamsmanager.personnes.dtos;

import fr.ropi.spring.teamsmanager.personnes.NiveauCompetence;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PersonneMeilleurCompDTO {

    private String id;
    private String nom;
    private String prenom;
    private NiveauCompetence niveauCompetence;
}
