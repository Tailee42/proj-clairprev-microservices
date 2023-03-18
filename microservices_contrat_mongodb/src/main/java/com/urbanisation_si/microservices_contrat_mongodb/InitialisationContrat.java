package com.urbanisation_si.microservices_contrat_mongodb;

import com.urbanisation_si.microservices_contrat_mongodb.dao.ContratRepository;
import com.urbanisation_si.microservices_contrat_mongodb.modele.Contrat;
import com.urbanisation_si.microservices_contrat_mongodb.modele.StatusContrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class InitialisationContrat implements ApplicationRunner {

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public void run(ApplicationArguments args) {

        Contrat c1 = new Contrat();
        c1.setDateDebut(LocalDate.of(2022, Month.JANUARY, 5));
        c1.setNumeroAssure(123456L);
        c1.setNumeroProduit(456L);
        c1.setNumeroContrat(48656L);
        c1.setStatusContrat(StatusContrat.REALISE);
        contratRepository.save(c1);

    }

}
