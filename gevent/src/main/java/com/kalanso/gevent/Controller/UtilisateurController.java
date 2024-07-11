package com.kalanso.gevent.Controller;

import com.kalanso.gevent.Model.Utilisateur;
import com.kalanso.gevent.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/creer")
    public ResponseEntity<?> registerUser(@RequestBody Utilisateur utilisateur) {
        utilisateurService.saveUser(utilisateur);
        return ResponseEntity.ok("Utilisateur enregistré avec succès");
    }

    @GetMapping("/liste/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUserById(id);
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Utilisateur>> getAllUsers() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUsers();
        return ResponseEntity.ok(utilisateurs);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUser(id, utilisateurDetails);
        return ResponseEntity.ok(updatedUtilisateur);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        utilisateurService.deleteUser(id);
        return ResponseEntity.ok("Utilisateur supprimé avec succès");
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Utilisateur> getUserByUsername(@PathVariable String username) {
        Utilisateur utilisateur = utilisateurService.getUserByUsername(username);
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Utilisateur> getUserByEmail(@PathVariable String email) {
        Utilisateur utilisateur = utilisateurService.getUserByEmail(email);
        return ResponseEntity.ok(utilisateur);
    }
}

