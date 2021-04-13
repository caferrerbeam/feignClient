package edu.eam.sistemasdistribuidos.integrationhttp.services;

import edu.eam.sistemasdistribuidos.integrationhttp.externalApi.model.StarWarsPerson;
import edu.eam.sistemasdistribuidos.integrationhttp.externalApi.services.StarWarsApiService;
import edu.eam.sistemasdistribuidos.integrationhttp.model.entities.Person;
import edu.eam.sistemasdistribuidos.integrationhttp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StarWarsApiService starWarsApiService;

    public void crearPersona(Person person) {
        personRepository.save(person);
    }

    public Person buscarPersona(String id) {

        StarWarsPerson starWarsPerson = starWarsApiService.findPersonById(id);

        if (starWarsPerson == null) {
            throw new EntityNotFoundException("star wars person not found");
        }

        return personRepository.save(new Person(id, starWarsPerson.getName(),
                starWarsPerson.getGender(),
                starWarsPerson.getBirthYear(),
                starWarsPerson.getHomeWorld()));
    }
}
