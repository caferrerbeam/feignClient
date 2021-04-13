package edu.eam.sistemasdistribuidos.integrationhttp.repositories;

import edu.eam.sistemasdistribuidos.integrationhttp.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository<Person, String> {
}
