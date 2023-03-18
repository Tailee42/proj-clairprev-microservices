package com.urbanisation_si.microservices_produit.dao;

import com.urbanisation_si.microservices_produit.modele.Produit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {
    List<Produit> findByNumeroProduit(long numeroProduit);
}
