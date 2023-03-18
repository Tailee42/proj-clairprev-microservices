package com.urbanisation_si.microservices_contrat_mongodb.dao;

import com.urbanisation_si.microservices_contrat_mongodb.modele.Contrat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ContratRepository extends MongoRepository<Contrat, String> {
    List<Contrat> findByNumeroContrat(Long numeroContrat);
    List<Contrat> findByNumeroAssure(Long numeroContrat);
    List<Contrat> findByNumeroProduit(Long numeroProduit);
}
