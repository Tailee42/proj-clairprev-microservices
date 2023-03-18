package com.urbanisation_si.microservices_assure.http.controleur;

import com.urbanisation_si.microservices_assure.configuration.ApplicationPropertiesConfiguration;
import com.urbanisation_si.microservices_assure.dao.AssureRepository;
import com.urbanisation_si.microservices_assure.modele.Assure;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Api(description = "API pour les opérations CRUD pour les assurés")
@RestController
@RequestMapping(path = "/previt")
public class AssureControleur {
    @Autowired
    private AssureRepository assureRepository;
    @Autowired
    ApplicationPropertiesConfiguration appProperties;

    @PostMapping(path = "/ajouterAssure")
    public ResponseEntity<Void> creerAssure(@Valid @RequestBody Assure assure) {
        Assure assureAjoute = assureRepository.save(assure);

        if (assureAjoute == null) {
            return ResponseEntity.noContent().build();
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(assureAjoute.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Recherche un assuré grâce à son ID à condition que celui-ci existe.")
    @GetMapping(path="/Assure/{id}")
    public Assure rechercherAssureId(@PathVariable Integer id) {
        Optional<Assure> assure = assureRepository.findById(id);
        return assure.orElse(null);
    }


    @DeleteMapping(path = "/Assure/{id}")
    public void supprimerAssurer(@PathVariable Integer id) {
        assureRepository.deleteById(id);
    }

    @PutMapping (path = "/modifierAssure")
    public void modifierAssure(@RequestBody Assure assure) {
        assureRepository.save(assure);
    }

    // @ResponseBody => par défaut et Iterable et List se valent ici.
    @GetMapping(path = "/listerLesAssures")
    public @ResponseBody Iterable<Assure> getAllAssures() {
        Iterable<Assure> assures = assureRepository.findAll();
        List<Assure> assureList = StreamSupport
                .stream(assures.spliterator(), false)
                .collect(Collectors.toList());

        List<Assure> listeLimitee = new ArrayList<>();
        if (assureList.size() < appProperties.getLimiteNombreAssure()) {
            listeLimitee = assureList;
        } else {
            listeLimitee = assureList.subList(0, appProperties.getLimiteNombreAssure());
        }

        return listeLimitee;
    }

    @GetMapping(path = "/rechercherAssureNomPrenom/{nom}/{prenom}")
    public List<Assure> getAssuresByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return assureRepository.findByNomAndPrenom(nom, prenom);
    }

    @GetMapping(path = "/Assure/nomContient/{nom}")
    public List<Assure> getAssuresByPartOfNom(@PathVariable String nom) {
        return assureRepository.findByNomContaining(nom);
    }

    @GetMapping(path = "/Assure/avantDateNaissance/{date}")
    public List<Assure> getAssuresByBirthDayBefore(@PathVariable String date) {
        //TODO quand le parse ne marche pas.
        LocalDate localDate = LocalDate.parse(date);
        return assureRepository.findByDateNaissanceBefore(localDate);
    }

}
