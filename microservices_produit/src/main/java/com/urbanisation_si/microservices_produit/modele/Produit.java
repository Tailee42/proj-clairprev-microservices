package com.urbanisation_si.microservices_produit.modele;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Produit {
    @Id
    @GeneratedValue
    private Integer id;
    private String libelle;

    private Long numeroProduit;


    public Integer getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getNumeroProduit() {
        return numeroProduit;
    }

    public void setNumeroProduit(Long numeroProduit) {
        this.numeroProduit = numeroProduit;
    }
}
