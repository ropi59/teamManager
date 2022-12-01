package fr.ropi.spring.teamsmanager.persons;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/persons")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping("")
    public Person save(@RequestBody Person entity) {
        return personService.save(entity);
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable String id) {
        return personService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        personService.deleteById(id);
    }
}
