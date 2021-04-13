package edu.eam.sistemasdistribuidos.integrationhttp.controllers;

import edu.eam.sistemasdistribuidos.integrationhttp.model.entities.Person;
import edu.eam.sistemasdistribuidos.integrationhttp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    public PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personService.buscarPersona(id);
    }
}
