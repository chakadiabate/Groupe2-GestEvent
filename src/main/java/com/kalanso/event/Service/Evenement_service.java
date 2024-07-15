package com.kalanso.event.Service;

import com.kalanso.event.Model.Evenement;

import java.util.List;

public interface Evenement_service{

    //Methode pour ajouter un evenement
    String Ajout(Evenement evenement);

    //Methode pour afficher un evenement
    List<Evenement> Afficher(Evenement evenement);

    //Methode pour supprimer un evenement
    String Delete(Evenement evenement);

    //Methode pour mettre à jour un evenement
    Evenement update(Evenement evenement);
}
