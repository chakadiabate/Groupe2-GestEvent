package com.kalanso.gevent.Controller;

import com.kalanso.gevent.Model.LieuEvenement;
import com.kalanso.gevent.Service.LieuEvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lieux")
public class LieuEvenementController {

    @Autowired
    private LieuEvenementService lieuEvenementService;

    @PostMapping
    public ResponseEntity<LieuEvenement> createLieuEvenement(@RequestBody LieuEvenement lieuEvenement) {
        LieuEvenement savedLieuEvenement = lieuEvenementService.saveLieuEvenement(lieuEvenement);
        return ResponseEntity.ok(savedLieuEvenement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LieuEvenement> getLieuEvenementById(@PathVariable Long id) {
        LieuEvenement lieuEvenement = lieuEvenementService.getLieuEvenementById(id);
        return ResponseEntity.ok(lieuEvenement);
    }

    @GetMapping
    public ResponseEntity<List<LieuEvenement>> getAllLieuEvenements() {
        List<LieuEvenement> lieuxEvenements = lieuEvenementService.getAllLieuEvenements();
        return ResponseEntity.ok(lieuxEvenements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LieuEvenement> updateLieuEvenement(@PathVariable Long id, @RequestBody LieuEvenement lieuEvenementDetails) {
        LieuEvenement updatedLieuEvenement = lieuEvenementService.updateLieuEvenement(id, lieuEvenementDetails);
        return ResponseEntity.ok(updatedLieuEvenement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLieuEvenement(@PathVariable Long id) {
        lieuEvenementService.deleteLieuEvenement(id);
        return ResponseEntity.ok("Lieu d'événement supprimé avec succès");
    }
}

