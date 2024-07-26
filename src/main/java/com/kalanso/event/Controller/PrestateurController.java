package com.kalanso.event.Controller;

import com.kalanso.event.Model.Prestateur;
import com.kalanso.event.Service.PrestateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/prestateurs")
public class PrestateurController {

    @Autowired
    private PrestateurService prestateurService;

    @GetMapping
    public List<Prestateur> getAllPrestateurs() {
        return prestateurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestateur> getPrestateurById(@PathVariable Long id) {
        Optional<Prestateur> prestateur = prestateurService.findById(id);
        return prestateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prestateur createPrestateur(@RequestBody Prestateur prestateur) {
        return prestateurService.save(prestateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestateur> updatePrestateur(@PathVariable Long id, @RequestBody Prestateur prestateurDetails) {
        Optional<Prestateur> prestateur = prestateurService.findById(id);

        if (prestateur.isPresent()) {
            Prestateur prestateurToUpdate = prestateur.get();
            prestateurToUpdate.setNom(prestateurDetails.getNom());
            prestateurToUpdate.setEmail(prestateurDetails.getEmail());
            prestateurToUpdate.setProfile(prestateurDetails.getProfile());
            // Mettre à jour d'autres champs si nécessaire
            return ResponseEntity.ok(prestateurService.save(prestateurToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestateur(@PathVariable Long id) {
        Optional<Prestateur> prestateur = prestateurService.findById(id);

        if (prestateur.isPresent()) {
            prestateurService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
