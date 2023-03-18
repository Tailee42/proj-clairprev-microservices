package com.urbanisation_si.processus_contrat.proxy;

import com.urbanisation_si.processus_contrat.dto.AssureDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = "microservices-assure", url = "localhost:9999")
public interface AssureProxy {
    @GetMapping(path = "/previt/listerLesAssures")
    public @ResponseBody List<AssureDTO> getAllAssures();

    @GetMapping(path = "/previt/rechercherAssureNomPrenom/{nom}/{prenom}")
    public List<AssureDTO> getAssuresByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom);
}
