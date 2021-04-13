package edu.eam.sistemasdistribuidos.integrationhttp.externalApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StarWarsPerson {

    private String name;

    private String gender;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("homeworld")
    private String homeWorld;

    public StarWarsPerson() {
    }

    public StarWarsPerson(String name, String gender, String birthYear, String homeWorld) {
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.homeWorld = homeWorld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }
}
