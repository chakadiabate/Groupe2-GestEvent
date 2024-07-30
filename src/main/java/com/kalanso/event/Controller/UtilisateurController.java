package com.kalanso.event.Controller;

import com.kalanso.event.Model.*;
import com.kalanso.event.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("gestEvent/user")
@AllArgsConstructor
public class UtilisateurController {
   @Autowired
    private Utilisateur_service utilisateurService;

    @PostMapping("/CreerAdmin")
    public Admin CreerAdmin(@RequestBody Admin admin){
        return utilisateurService.createAdmin(admin);
    }

    @PostMapping("/CreerGest")
    public Gestionnaire CreerGest(@RequestBody Gestionnaire gestionnaire){
        return utilisateurService.CreerGestionnaire(gestionnaire);
    }

    @PostMapping("/CreerClient")
    public Client creerClient(@RequestBody Client client){
        return utilisateurService.creerClient(client);
    }

    @PostMapping("/CreerOrga")
    public Organisateur creerClient(@RequestBody Organisateur organisateur){
        return utilisateurService.creerOrganisateur(organisateur);
    }

    @GetMapping("/Users")
    List<Utilisateur> displayUsers(){
        return utilisateurService.displayAll();
    }

    @GetMapping("/User/{id}")
    Utilisateur displayUser(@PathVariable Integer id){
        return utilisateurService.display(id);
    }

    @GetMapping("/TriParNom")
    List<Utilisateur> TrierByname(String nom){
        return utilisateurService.listeParNom(nom);
    }


    @PutMapping("/UpdateUser/{id}")
    public Utilisateur UpdateUser(@PathVariable Integer id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.update(id, utilisateur);
    }

    @DeleteMapping("/deleteUser/{id}")
    public  String supprimerAdmin( @PathVariable Integer id){
        return utilisateurService.delete(id);
    }
}
