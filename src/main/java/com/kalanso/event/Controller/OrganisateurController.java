package com.kalanso.event.Controller;


import com.kalanso.event.Model.Organisateur;
import com.kalanso.event.Service.OrgaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Utilisateur/Organisateur")
@AllArgsConstructor

public class OrganisateurController {

    private final OrgaService orgaService;

    @PostMapping("/CreerOrganisateur")
    public Organisateur creerOrganisateur(@RequestBody Organisateur organisateur){
        return orgaService.creerOrganisateur(organisateur);
    }

    @GetMapping("/ListeOrganisateur")
    public List<Organisateur> listerOrganisateur(){
        return orgaService.listerOrganisateur();
    }

    @PutMapping("/ModifierOrganisateur")
    public Organisateur modifierOrganisateur(@PathVariable Long id,@RequestBody Organisateur organisateur){
        return orgaService.modifierOrganisateur(id, organisateur);
    }

    @DeleteMapping("/SupprimerOrganisateur")
    public String supprimerOrganisateur(@PathVariable Long id){
        return orgaService.supprimerOrganisateur(id);
    }

}
