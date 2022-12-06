package fr.ropi.spring.teamsmanager.utils;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Entity {

    @Id
    protected String id;
    protected LocalDateTime dateCreation = LocalDateTime.now();
    protected LocalDateTime dateModification = LocalDateTime.now();

}
