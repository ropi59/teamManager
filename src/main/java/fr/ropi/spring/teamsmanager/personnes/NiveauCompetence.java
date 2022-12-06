package fr.ropi.spring.teamsmanager.personnes;

import fr.ropi.spring.teamsmanager.competences.Competence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NiveauCompetence {
    @DBRef
    private Competence competence;
    private Integer niveau;
}
