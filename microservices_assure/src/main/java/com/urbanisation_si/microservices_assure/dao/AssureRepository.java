package com.urbanisation_si.microservices_assure.dao;

import com.urbanisation_si.microservices_assure.modele.Assure;
import org.apache.tomcat.jni.Local;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AssureRepository extends CrudRepository<Assure, Integer> {
    List<Assure>  findByNomAndPrenom (String nom, String prenom);

    List<Assure> findByNomContaining (String nom);

    List<Assure> findByDateNaissanceBefore (LocalDate date);
}
