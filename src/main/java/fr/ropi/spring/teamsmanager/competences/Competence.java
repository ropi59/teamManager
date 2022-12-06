package fr.ropi.spring.teamsmanager.competences;

import fr.ropi.spring.teamsmanager.utils.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Competence extends Entity {
    private String nom;
    private String description;

    public Competence(String id) {
        this.id = id;
    }

    public Competence(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
}
