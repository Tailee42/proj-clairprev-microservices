package com.urbanisation_si.processus_contrat.proxy;

import com.urbanisation_si.processus_contrat.dto.ContratDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "microservices-contrat-mongodb", url="localhost:9996")
public interface ContratProxy {
    @PostMapping(path = "/previt/ajouterContrat")
    public ContratDTO creerContrat(ContratDTO contrat) ;
}
