package com.urbanisation_si.microservices_assure.modele;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
    @Id
    @GeneratedValue
    private Integer id;
    @Length(min=3, max=30, message = "Le nombre de caractères du nom de la personne doit être compris entre 3 et 30 au sens large.")
    private String nom;
    private String prenom;
    @NotNull
    private Long numeroPersonne;
    private LocalDate dateNaissance;


    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getNumeroPersonne() {
        return numeroPersonne;
    }

    public void setNumeroPersonne(Long numeroPersonne) {
        this.numeroPersonne = numeroPersonne;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
