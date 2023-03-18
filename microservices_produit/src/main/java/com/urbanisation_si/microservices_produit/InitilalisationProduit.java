package com.urbanisation_si.microservices_produit;

import com.urbanisation_si.microservices_produit.dao.ProduitRepository;
import com.urbanisation_si.microservices_produit.modele.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitilalisationProduit implements ApplicationRunner {
    @Autowired
    private ProduitRepository produitRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Produit p1 = new Produit();
        p1.setLibelle("Assurance Vie Tempo");
        p1.setNumeroProduit(123L);
        produitRepository.save(p1);

        Produit p2 = new Produit();
        p2.setLibelle("Assurance habitation");
        p2.setNumeroProduit(456L);
        produitRepository.save(p2);
    }
}
