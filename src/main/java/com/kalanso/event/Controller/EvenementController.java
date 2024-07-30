package com.kalanso.event.Controller;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Service.Evenement_service;
import com.kalanso.event.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*")
@Controller
@RestController
@RequestMapping("/gestEvent/event")
@AllArgsConstructor
public class EvenementController {

    private Evenement_service evenementService;

    @PostMapping("/addEvent")
    private String ajout (@RequestBody Evenement evenement){
        return evenementService.Ajout(evenement);
    }


    @GetMapping("/afficher")
    private List<Evenement> Afficher(Evenement evenement) {
        return evenementService.Afficher(evenement);
    }

    @DeleteMapping("/delete")
    public String Delete(Evenement evenement) {
        return evenementService.Delete(evenement);
    }

    @PutMapping("/update")
    public Evenement update(Evenement evenement) {
        return evenementService.update(evenement);
    }
}
