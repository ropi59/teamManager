package fr.ropi.spring.teamsmanager.personnes;

import fr.ropi.spring.teamsmanager.utils.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Personne extends Entity {

    private String nom;
    private String prenom;

    private List<NiveauCompetence> competences = new ArrayList<>();
}
