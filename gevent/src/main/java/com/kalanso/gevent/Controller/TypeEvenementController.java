package com.kalanso.gevent.Controller;

import com.kalanso.gevent.Model.TypeEvenement;
import com.kalanso.gevent.Service.TypeEvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeEvenementController {

    @Autowired
    private TypeEvenementService typeEvenementService;

    @PostMapping
    public ResponseEntity<TypeEvenement> createTypeEvenement(@RequestBody TypeEvenement typeEvenement) {
        TypeEvenement savedTypeEvenement = typeEvenementService.saveTypeEvenement(typeEvenement);
        return ResponseEntity.ok(savedTypeEvenement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeEvenement> getTypeEvenementById(@PathVariable Long id) {
        TypeEvenement typeEvenement = typeEvenementService.getTypeEvenementById(id);
        return ResponseEntity.ok(typeEvenement);
    }

    @GetMapping
    public ResponseEntity<List<TypeEvenement>> getAllTypeEvenements() {
        List<TypeEvenement> typesEvenements = typeEvenementService.getAllTypeEvenements();
        return ResponseEntity.ok(typesEvenements);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeEvenement> updateTypeEvenement(@PathVariable Long id, @RequestBody TypeEvenement typeEvenementDetails) {
        TypeEvenement updatedTypeEvenement = typeEvenementService.updateTypeEvenement(id, typeEvenementDetails);
        return ResponseEntity.ok(updatedTypeEvenement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTypeEvenement(@PathVariable Long id) {
        typeEvenementService.deleteTypeEvenement(id);
        return ResponseEntity.ok("Type d'événement supprimé avec succès");
    }
}

