package com.urbanisation_si.microservices_contrat.http.controleur;

import com.urbanisation_si.microservices_contrat.dao.ContratRepository;
import com.urbanisation_si.microservices_contrat.modele.Contrat;
import com.urbanisation_si.microservices_contrat.service.ContratService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Api(description = "API pour les opérations CRUD pour les contrats")
@RestController
@RequestMapping(path = "/previt")
public class ContratControleur {
    @Autowired
    private ContratRepository contratRepository;
    private ContratService contratService = new ContratService();

    @PostMapping(path = "/ajouterContrat")
    public ResponseEntity<Void> creerContrat(@Valid @RequestBody Contrat contrat) {
        Contrat contratMisAJour = contratService.miseAJourStatus(contrat);

        Contrat contratAjoute = contratRepository.save(contratMisAJour);

        if (contratAjoute == null) {
            return ResponseEntity.noContent().build();
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contratAjoute.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
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
