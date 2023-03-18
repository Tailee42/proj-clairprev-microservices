package com.urbanisation_si.microservices_contrat_mongodb.http.controleur;

import com.urbanisation_si.microservices_contrat_mongodb.dao.ContratRepository;
import com.urbanisation_si.microservices_contrat_mongodb.exceptions.ContratInexistantException;
import com.urbanisation_si.microservices_contrat_mongodb.exceptions.CreationContratImpossibleException;
import com.urbanisation_si.microservices_contrat_mongodb.modele.Contrat;
import com.urbanisation_si.microservices_contrat_mongodb.service.ContratService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(description = "API pour les opérations CRUD pour les contrats")
@RestController
@RequestMapping(path = "/previt")
public class ContratControleur {
    @Autowired
    private ContratRepository contratRepository;
    private ContratService contratService = new ContratService();

    @PostMapping(path = "/ajouterContrat")
    public ResponseEntity<Contrat> creerContrat(@Valid @RequestBody Contrat contrat) {
        Contrat contratMisAJour = contratService.miseAJourStatus(contrat);
        Contrat contratAjoute = contratRepository.save(contratMisAJour);

        if (contratAjoute == null) throw new CreationContratImpossibleException("Impossible de créer le contrat");

        return new ResponseEntity<Contrat>(contratAjoute, HttpStatus.CREATED);
    }

    @GetMapping(path = "/rechercherId/{id}")
    public Optional<Contrat> rechercherContratId(@PathVariable String id) {
        Optional<Contrat> contratRecherche = contratRepository.findById(id);
        if (!contratRecherche.isPresent()) throw new ContratInexistantException("Ce contrat n'existe pas");
        return contratRecherche;
    }

    @GetMapping(path = "/listerLesContrats")
    public @ResponseBody Iterable<Contrat> getAllAssures() {
        return contratRepository.findAll();
    }

    @GetMapping(path = "/rechercherContratNumeroContrat/{numero}")
    public List<Contrat> getContratsByNumeroContrat(@PathVariable int numero) {
        return contratRepository.findByNumeroContrat((long) numero);
    }

    @GetMapping(path = "/rechercherContratNumeroAssure/{numero}")
    public List<Contrat> getContratsByNumeroAssure(@PathVariable int numero) {
        return contratRepository.findByNumeroAssure((long) numero);
    }

    @GetMapping(path = "/rechercherContratNumeroProduit/{numero}")
    public List<Contrat> getContratsByNumeroProduit(@PathVariable int numero) {
        return contratRepository.findByNumeroProduit((long) numero);
    }
}
