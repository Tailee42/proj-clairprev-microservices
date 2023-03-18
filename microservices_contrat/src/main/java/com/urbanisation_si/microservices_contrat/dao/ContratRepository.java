package com.urbanisation_si.microservices_contrat.dao;

import com.urbanisation_si.microservices_contrat.modele.Contrat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContratRepository extends CrudRepository<Contrat, Integer> {
    List<Contrat> findByNumeroContrat(Long numeroContrat);
    List<Contrat> findByNumeroAssure(Long numeroContrat);
    List<Contrat> findByNumeroProduit(Long numeroProduit);
}
