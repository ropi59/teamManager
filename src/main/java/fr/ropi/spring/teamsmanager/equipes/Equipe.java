package fr.ropi.spring.teamsmanager.equipes;

import fr.ropi.spring.teamsmanager.personnes.Personne;
import fr.ropi.spring.teamsmanager.utils.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe extends Entity {
    private String nom;
    @DBRef
    private Set<Personne> membres = new HashSet<>();

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Equipe equipe = (Equipe) other;

        return Objects.equals(id, equipe.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
