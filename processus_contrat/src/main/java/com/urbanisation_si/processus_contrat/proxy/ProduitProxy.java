package com.urbanisation_si.processus_contrat.proxy;

import com.urbanisation_si.processus_contrat.dto.ProduitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = "microservices-produit", url="localhost:9998")
public interface ProduitProxy {

    @GetMapping(path = "/h2/listerLesProduits")
    public @ResponseBody List<ProduitDTO> getAllProducts();
}
