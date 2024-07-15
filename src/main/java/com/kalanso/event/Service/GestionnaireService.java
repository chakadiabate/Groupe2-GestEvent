package com.kalanso.event.Service;

import com.kalanso.event.Model.Gestionnaire;

import java.util.List;

public interface GestionnaireService {
    Gestionnaire CreerGestionnaire(Gestionnaire gestionnaire);
    List<Gestionnaire> listeGestionnaire();
    Gestionnaire modifierGestionnaire(Long id, Gestionnaire gestionnaire);
    String SupprimerGestionnaire(Long id);
}
