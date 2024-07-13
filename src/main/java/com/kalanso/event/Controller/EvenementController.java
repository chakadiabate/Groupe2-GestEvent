package com.kalanso.event.Controller;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Service.Evenement_service;
import com.kalanso.event.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EvenementController {

    private Evenement_service evenementService;

    @PostMapping("/addEvent")
    private Evenement ajout (@RequestBody Evenement evenement){
        return evenementService.Ajout(evenement);
    }

}
