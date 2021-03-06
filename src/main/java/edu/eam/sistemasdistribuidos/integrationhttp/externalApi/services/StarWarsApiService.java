package edu.eam.sistemasdistribuidos.integrationhttp.externalApi.services;

import edu.eam.sistemasdistribuidos.integrationhttp.externalApi.clients.StarWarsAPIClient;
import edu.eam.sistemasdistribuidos.integrationhttp.externalApi.model.StarWarsPerson;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class StarWarsApiService {

    @Autowired
    private StarWarsAPIClient starWarsAPIClient;

    @Cacheable(value = "personFromStarWarsAPI", key = "#id", cacheManager = "expire30Secs")
    public StarWarsPerson findPersonById(String id) {
        System.out.println("personFromStarWarsAPI");
        try {
            return starWarsAPIClient.findPersonById(id);
        } catch (FeignException.NotFound exc) {
           return null;
        } catch (FeignException.InternalServerError exc) {
            throw new RuntimeException("Error general...");
        }
    }
}
