package com.urbanisation_si.microservices_produit.http.controleur;

import com.urbanisation_si.microservices_produit.dao.ProduitRepository;
import com.urbanisation_si.microservices_produit.modele.Produit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Api(description = "APi pour les opérations CRUD pour les produits")
@RestController
@RequestMapping(path = "/h2")
public class ProduitControleur {
    @Autowired
    private ProduitRepository produitRepository;

    @PostMapping(path = "/ajouterProduit")
    public ResponseEntity<Void> createProduct(@Valid @RequestBody Produit produit) {
        Produit produitAdded = produitRepository.save(produit);

        if (produitAdded == null) {
            return ResponseEntity.noContent().build();
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produitAdded.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/listerLesProduits")
    public @ResponseBody Iterable<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @ApiOperation(value = "Recherche un produit grâce à son numéro de produit.")
    @GetMapping(path="/Produit/{numero}")
    public List<Produit> rechercherProduitNumeroProduit(@PathVariable int numero) {
        Long numeroLong = (long) numero;
        return produitRepository.findByNumeroProduit(numeroLong);
    }
}
