package edu.eam.sistemasdistribuidos.integrationhttp.externalApi.services;

import edu.eam.sistemasdistribuidos.integrationhttp.externalApi.clients.StarWarsAPIClient;
import edu.eam.sistemasdistribuidos.integrationhttp.externalApi.model.StarWarsPerson;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class StarWarsApiService {

    @Autowired
    private StarWarsAPIClient starWarsAPIClient;

    public StarWarsPerson findPersonById(String id) {
        try {
            return starWarsAPIClient.findPersonById(id);
        } catch (FeignException.NotFound exc) {
           return null;
        } catch (FeignException.InternalServerError exc) {
            throw new RuntimeException("Error general...");
        }
    }
}
