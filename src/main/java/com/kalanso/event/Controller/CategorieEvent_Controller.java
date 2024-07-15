package com.kalanso.event.Controller;

import com.kalanso.event.Model.CategorieEvent;
import com.kalanso.event.Service.CategorieEvent_service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/EventCat")
public class CategorieEvent_Controller {

    CategorieEvent_service categorieEventService;

    @PutMapping("/AjouterEventCats")
    public CategorieEvent AjouterEventCat(CategorieEvent Cat){
        return categorieEventService.AjouterCategorie(Cat);
    }

    @GetMapping("/listeEventCat")
    public List<CategorieEvent> ListeEventcat(){
        return categorieEventService.ListeCategorie();
    }

    @DeleteMapping("/supEventCat")
    public String SupEventCat(Long id){
        return categorieEventService.supprimer(id);
    }
    @PutMapping("/modifEventCat")
    public CategorieEvent modifierEventCat(Long id, CategorieEvent Cat){
        return categorieEventService.ModifierCategorie(id, Cat);
    }

}
