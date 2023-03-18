package com.urbanisation_si.microservices_assure;

import com.urbanisation_si.microservices_assure.dao.AssureRepository;
import com.urbanisation_si.microservices_assure.modele.Assure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class InitialisationAssure implements ApplicationRunner {

    @Autowired
    private AssureRepository assureRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Assure a1 = new Assure();
        a1.setNom("Albrand");
        a1.setPrenom("Albert");
        a1.setNumeroPersonne(123L);
        a1.setNumeroAssure(123456L);
        a1.setDateNaissance(LocalDate.of(2000, Month.MARCH, 23));
        a1.setDossierMedical("Asthme");
        assureRepository.save(a1);

        Assure a2 = new Assure();
        a2.setNom("Queyras");
        a2.setPrenom("Joseph");
        a2.setNumeroPersonne(159L);
        a2.setNumeroAssure(486153L);
        a2.setDateNaissance(LocalDate.of(1980, Month.APRIL, 12));
        a2.setDossierMedical("RAS");
        assureRepository.save(a2);

        Assure a3 = new Assure();
        a3.setNom("Roux");
        a3.setPrenom("Bernard");
        a3.setNumeroPersonne(8522L);
        a3.setNumeroAssure(741936L);
        a3.setDateNaissance(LocalDate.of(1999, Month.JULY, 1));
        a3.setDossierMedical("RAS");
        assureRepository.save(a3);

    }

}
