package com.urbanisation_si.processus_contrat.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ContratDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;
    private Long numeroContrat;
    private Long numeroAssure;
    private Long numeroProduit;
    private StatusContrat statusContrat;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContratDTO that = (ContratDTO) o;

        if (getDateDebut() != null ? !getDateDebut().equals(that.getDateDebut()) : that.getDateDebut() != null)
            return false;
        if (getNumeroContrat() != null ? !getNumeroContrat().equals(that.getNumeroContrat()) : that.getNumeroContrat() != null)
            return false;
        if (getNumeroAssure() != null ? !getNumeroAssure().equals(that.getNumeroAssure()) : that.getNumeroAssure() != null)
            return false;
        if (getNumeroProduit() != null ? !getNumeroProduit().equals(that.getNumeroProduit()) : that.getNumeroProduit() != null)
            return false;
        return getStatusContrat() == that.getStatusContrat();
    }

    @Override
    public int hashCode() {
        int result = getDateDebut() != null ? getDateDebut().hashCode() : 0;
        result = 31 * result + (getNumeroContrat() != null ? getNumeroContrat().hashCode() : 0);
        result = 31 * result + (getNumeroAssure() != null ? getNumeroAssure().hashCode() : 0);
        result = 31 * result + (getNumeroProduit() != null ? getNumeroProduit().hashCode() : 0);
        result = 31 * result + (getStatusContrat() != null ? getStatusContrat().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContratDTO{");
        sb.append("dateDebut=").append(dateDebut);
        sb.append(", numeroContrat=").append(numeroContrat);
        sb.append(", numeroAssure=").append(numeroAssure);
        sb.append(", numeroProduit=").append(numeroProduit);
        sb.append(", statusContrat=").append(statusContrat);
        sb.append('}');
        return sb.toString();
    }
}
