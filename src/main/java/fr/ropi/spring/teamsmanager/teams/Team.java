package fr.ropi.spring.teamsmanager.teams;

import fr.ropi.spring.teamsmanager.persons.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    private String id;
    private String nom;
    private List<Person> membres = new ArrayList<>();
}
