package com.kalanso.event.Controller;

import com.kalanso.event.Model.Gestionnaire;
import com.kalanso.event.Service.GestionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Utilisateur/Gestionnaire")
@AllArgsConstructor

public class GestionnaireController {

    private  final GestionnaireService gestionnaireService;

    @PostMapping("/CreerGestionnaire")
    public Gestionnaire CreerGestionnaire(Gestionnaire gestionnaire){
        return gestionnaireService.CreerGestionnaire(gestionnaire);
    }

    @GetMapping("/ListeGestionniare")
    List<Gestionnaire> listeGestionnaire(){
        return gestionnaireService.listeGestionnaire();
    }

    @PutMapping("/ModifierGestionnaire")
    public Gestionnaire modifierGestionnaire(@PathVariable Long id,@RequestBody Gestionnaire gestionnaire){
        return gestionnaireService.modifierGestionnaire(id, gestionnaire);
    }

    @DeleteMapping("/SupprimerGestionnaire")
    public String SupprimerGestionnaire(@PathVariable Long id){
        return gestionnaireService.SupprimerGestionnaire(id);
    }
}
