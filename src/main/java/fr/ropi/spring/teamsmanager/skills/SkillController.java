package fr.ropi.spring.teamsmanager.skills;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("")
    public List<Skill> findAll() {
        return skillService.findAll();
    }

    @PostMapping("")
    public Skill save(@RequestBody Skill entity) {
        return skillService.save(entity);
    }

    @GetMapping("{id}")
    public Skill findById(@PathVariable String id) {
        return skillService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        skillService.deleteById(id);
    }
}
