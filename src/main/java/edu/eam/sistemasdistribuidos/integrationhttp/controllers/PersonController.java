package edu.eam.sistemasdistribuidos.integrationhttp.controllers;

import edu.eam.sistemasdistribuidos.integrationhttp.model.entities.Person;
import edu.eam.sistemasdistribuidos.integrationhttp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    public PersonService personService;

    @GetMapping("/{id}/fromStarWars")
    public Person getPersonFromApi(@PathVariable String id) {
        return personService.buscarPersona(id);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.buscarDesdeBD(id);
    }

    @PutMapping("/{id}")
    public void editPerson(@RequestBody Person p) {
        personService.editarPerson(p);
    }
}
