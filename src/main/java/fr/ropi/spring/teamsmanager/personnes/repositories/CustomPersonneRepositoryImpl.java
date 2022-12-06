package fr.ropi.spring.teamsmanager.personnes.repositories;

import fr.ropi.spring.teamsmanager.competences.Competence;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

public class CustomPersonneRepositoryImpl implements CustomPersonneRepository{

    private final MongoTemplate template;

    public CustomPersonneRepositoryImpl(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public void deleteCompetenceByCompetenceId(String idPersonne, String idCompetence) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(idPersonne));
        Update update = new Update();
        update.pull("competences.competence", new Competence(idCompetence));
    }
}
