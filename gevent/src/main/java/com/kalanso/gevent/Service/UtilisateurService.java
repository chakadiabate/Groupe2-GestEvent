package com.kalanso.gevent.Service;

import com.kalanso.gevent.Model.Utilisateur;
import com.kalanso.gevent.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur saveUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUserById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
    }

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur updateUser(Long id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = getUserById(id);

        utilisateur.setUsername(utilisateurDetails.getUsername());
        utilisateur.setPassword(utilisateurDetails.getPassword());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setRoles(utilisateurDetails.getRoles());

        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUser(Long id) {
        Utilisateur utilisateur = getUserById(id);
        utilisateurRepository.delete(utilisateur);
    }

    public Utilisateur getUserByUsername(String username) {
        return utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec le nom d'utilisateur : " + username));
    }

    public Utilisateur getUserByEmail(String email) {
        return (Utilisateur) utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'email : " + email));
    }
}

