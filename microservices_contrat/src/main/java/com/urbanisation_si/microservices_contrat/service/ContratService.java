package com.urbanisation_si.microservices_contrat.service;

import com.urbanisation_si.microservices_contrat.dao.ContratRepository;
import com.urbanisation_si.microservices_contrat.modele.Contrat;
import com.urbanisation_si.microservices_contrat.modele.StatusContrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratService {
    @Autowired
    private ContratRepository contratRepository;

    public Contrat miseAJourStatus(Contrat contrat) {
        if (contrat.getNumeroProduit() == null) {
            contrat.setStatusContrat(StatusContrat.EN_ATTENTE_PRODUIT);
        } else if (contrat.getNumeroContrat() == null) {
            contrat.setStatusContrat(StatusContrat.EN_ATTENTE_NUMERO_CONTRAT);
        } else if (contrat.getDateDebut() == null) {
            contrat.setStatusContrat(StatusContrat.EN_ATTENTE_DATE);
        } else {
            contrat.setStatusContrat(StatusContrat.REALISE);
        }
        return contrat;
    }

}
