package edu.eam.sistemasdistribuidos.integrationhttp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    private String id;

    private String nombre;
    private String genero;

    @Column(name = "nacimiento")
    private String anhoNacimiento;

    @Column(name = "lugar_nacimiento")
    private String lugarNAcimiento;

    public Person() {
    }

    public Person(String nombre, String genero, String anhoNacimiento, String lugarNAcimiento) {
        this.nombre = nombre;
        this.genero = genero;
        this.anhoNacimiento = anhoNacimiento;
        this.lugarNAcimiento = lugarNAcimiento;
    }

    public Person(String id, String nombre, String genero, String anhoNacimiento, String lugarNAcimiento) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.anhoNacimiento = anhoNacimiento;
        this.lugarNAcimiento = lugarNAcimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnhoNacimiento() {
        return anhoNacimiento;
    }

    public void setAnhoNacimiento(String anhoNacimiento) {
        this.anhoNacimiento = anhoNacimiento;
    }

    public String getLugarNAcimiento() {
        return lugarNAcimiento;
    }

    public void setLugarNAcimiento(String lugarNAcimiento) {
        this.lugarNAcimiento = lugarNAcimiento;
    }
}
