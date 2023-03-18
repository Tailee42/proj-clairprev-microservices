package com.urbanisation_si.microservices_contrat.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Contrat {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate dateDebut;
    private Long numeroContrat;
    private Long numeroAssure;
    private Long numeroProduit;
    private StatusContrat statusContrat;

    public Integer getId() {
        return id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Long getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(Long numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public Long getNumeroAssure() {
        return numeroAssure;
    }

    public void setNumeroAssure(Long numeroAssure) {
        this.numeroAssure = numeroAssure;
    }

    public Long getNumeroProduit() {
        return numeroProduit;
    }

    public void setNumeroProduit(Long numeroProduit) {
        this.numeroProduit = numeroProduit;
    }

    public StatusContrat getStatusContrat() {
        return statusContrat;
    }

    public void setStatusContrat(StatusContrat statusContrat) {
        this.statusContrat = statusContrat;
    }
}
