package com.urbanisation_si.processus_contrat.dto;

public class ProduitDTO {

    private String libelle;

    private Long numeroProduit;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProduitDTO{");
        sb.append("libelle='").append(libelle).append('\'');
        sb.append(", numeroProduit=").append(numeroProduit);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProduitDTO that = (ProduitDTO) o;

        if (getLibelle() != null ? !getLibelle().equals(that.getLibelle()) : that.getLibelle() != null) return false;
        return getNumeroProduit() != null ? getNumeroProduit().equals(that.getNumeroProduit()) : that.getNumeroProduit() == null;
    }

    @Override
    public int hashCode() {
        int result = getLibelle() != null ? getLibelle().hashCode() : 0;
        result = 31 * result + (getNumeroProduit() != null ? getNumeroProduit().hashCode() : 0);
        return result;
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
