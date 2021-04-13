package edu.eam.sistemasdistribuidos.integrationhttp.externalApi.clients;

import edu.eam.sistemasdistribuidos.integrationhttp.externalApi.model.StarWarsPerson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "StarWarsAPIClient" , url = "https://swapi.dev/api")
public interface StarWarsAPIClient {

    @GetMapping("people/{id}/")
    StarWarsPerson findPersonById(@PathVariable String id);
}
