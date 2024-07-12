package com.kalanso.event.controller;

import com.kalanso.event.Model.Lieu;
import com.kalanso.event.Service.Lieu_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lieux")
public class LieuController {

    @Autowired
    private Lieu_service lieu_service;

    @GetMapping
    public List<Lieu> getAllLieux() {
        return lieu_service.getAllLieu();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lieu> getLieuById(@PathVariable Long id) {
        Lieu lieu = lieu_service.getLieuById(id);
        if (lieu != null) {
            return ResponseEntity.ok(lieu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLieu(@PathVariable Long id) {
        lieu_service.deleteLieu(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lieu> updateLieu(@PathVariable Integer id, @RequestBody Lieu lieuDetails) {
        Lieu updatedLieu = lieu_service.updateLieu(id, lieuDetails);
        return ResponseEntity.ok(updatedLieu);
    }
}
