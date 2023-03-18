package com.urbanisation_si.processus_contrat.dto;

public class AssureDTO {
    private String nom;
    private String prenom;
    private Long numeroAssure;

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

    public Long getNumeroAssure() {
        return numeroAssure;
    }

    public void setNumeroAssure(Long numeroAssure) {
        this.numeroAssure = numeroAssure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssureDTO assureDTO = (AssureDTO) o;

        if (!getNom().equals(assureDTO.getNom())) return false;
        if (!getPrenom().equals(assureDTO.getPrenom())) return false;
        return getNumeroAssure().equals(assureDTO.getNumeroAssure());
    }

    @Override
    public int hashCode() {
        int result = getNom().hashCode();
        result = 31 * result + getPrenom().hashCode();
        result = 31 * result + getNumeroAssure().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AssureDTO{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", numeroAssure=").append(numeroAssure);
        sb.append('}');
        return sb.toString();
    }
}
