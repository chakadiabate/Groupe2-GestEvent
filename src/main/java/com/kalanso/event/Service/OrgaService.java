package com.kalanso.event.Service;

import com.kalanso.event.Model.Organisateur;
import com.kalanso.event.Model.Prestateur;

import java.util.List;

public interface OrgaService {

    Organisateur creerOrganisateur(Organisateur organisateur);
    List<Organisateur> listerOrganisateur();
    Organisateur modifierOrganisateur(Integer id,Organisateur organisateur);
    String supprimerOrganisateur(Integer id);


}
