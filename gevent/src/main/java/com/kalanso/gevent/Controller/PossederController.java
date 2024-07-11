package com.kalanso.gevent.Controller;

import com.kalanso.gevent.Model.Posseder;
import com.kalanso.gevent.Service.PossederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posseder")
public class PossederController {

    @Autowired
    private PossederService possederService;

    @PostMapping
    public ResponseEntity<Posseder> createPosseder(@RequestBody Posseder posseder) {
        Posseder savedPosseder = possederService.savePosseder(posseder);
        return ResponseEntity.ok(savedPosseder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posseder> getPossederById(@PathVariable Long id) {
        Posseder posseder = possederService.getPossederById(id);
        return ResponseEntity.ok(posseder);
    }

    @GetMapping
    public ResponseEntity<List<Posseder>> getAllPosseders() {
        List<Posseder> posseders = possederService.getAllPosseders();
        return ResponseEntity.ok(posseders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posseder> updatePosseder(@PathVariable Long id, @RequestBody Posseder possederDetails) {
        Posseder updatedPosseder = possederService.updatePosseder(id, possederDetails);
        return ResponseEntity.ok(updatedPosseder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePosseder(@PathVariable Long id) {
        possederService.deletePosseder(id);
        return ResponseEntity.ok("Relation Posseder supprimée avec succès");
    }
}

