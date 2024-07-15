package com.kalanso.event.Service;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Model.Utilisateur;

import java.util.List;

public interface Utilisateur_service {

    Admin Ajout (Admin admin);

    List<Utilisateur> update(String id);
}
