package com.kalanso.event.Service;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Model.Organisateur;
import com.kalanso.event.Model.Utilisateur;

import java.util.List;

public interface AdminService {

    Admin creerAdmin(Admin admin);
    List<Admin> listerAdmin();
    Admin modifierAdmin(Integer id,Admin admin);
    String supprimerAdmin(Integer id);

}
