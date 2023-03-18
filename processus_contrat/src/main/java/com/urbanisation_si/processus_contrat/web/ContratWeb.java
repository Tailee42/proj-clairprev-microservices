package com.urbanisation_si.processus_contrat.web;

import com.urbanisation_si.processus_contrat.dto.AssureDTO;
import com.urbanisation_si.processus_contrat.dto.ContratDTO;
import com.urbanisation_si.processus_contrat.dto.ProduitDTO;
import com.urbanisation_si.processus_contrat.proxy.AssureProxy;
import com.urbanisation_si.processus_contrat.proxy.ContratProxy;
import com.urbanisation_si.processus_contrat.proxy.ProduitProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Spring MVC application qui ne propose aucun service
// Le controller est mis en place par Spring Boot, sa chouche la plus basse est une servelet unique : DispatcherServelet

@Controller
public class ContratWeb {
    @Autowired
    private AssureProxy assureProxy;
    @Autowired
    private ProduitProxy produitProxy;
    @Autowired
    private ContratProxy contratProxy;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(Model model) {
        logger.debug("Appel de la page index.html");
//        List<AssureDTO> assures = assureProxy.getAllAssures();
//        //on place la collection 'assures dans Model
//        model.addAttribute("assures", assures);

        AssureDTO assureDTO = new AssureDTO();
        model.addAttribute("assureBean", assureDTO);
        return "index";
    }

    @PostMapping("/saisir-assure")
    public String chercherAssure(AssureDTO assureDTO,  Model model) {
        List<AssureDTO> assureDTOList = assureProxy.getAssuresByNomAndPrenom(assureDTO.getNom(), assureDTO.getPrenom());
        model.addAttribute("assures", assureDTOList);
        return "assures";
    }

    @GetMapping("/Assure/numeroAssure/{numeroAssure}")
    public String chercherproduits(AssureDTO assureDTO, Model model) {
        model.addAttribute("assure", assureDTO);

        List<ProduitDTO> produitDTOList = produitProxy.getAllProducts();
        model.addAttribute("produits", produitDTOList);
        return "produits";
    }

    @GetMapping("/Produit/numeroProduit/{numeroProduit}/{numeroAssure}")
    public ModelAndView afficherFormulaireDateContrat(AssureDTO assureDTO, ProduitDTO produitDTO) {
        ModelAndView modelAndView = new ModelAndView("formulaireContrat");
        ContratDTO contratDTO = new ContratDTO();
        contratDTO.setNumeroAssure(assureDTO.getNumeroAssure());
        contratDTO.setNumeroProduit(produitDTO.getNumeroProduit());

        modelAndView.addObject("contratBean", contratDTO);
        return modelAndView;
    }

    @PostMapping("/saisir-contrat")
    public String enregistrerContrat(ContratDTO contratDTO, Model model) {
        ContratDTO contratAjoute = contratProxy.creerContrat(contratDTO);
        model.addAttribute("contrat", contratAjoute);
        return "contrat";
    }

}
