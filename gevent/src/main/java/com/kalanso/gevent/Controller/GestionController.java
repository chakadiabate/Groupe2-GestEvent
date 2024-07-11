package com.kalanso.gevent.Controller;

import com.kalanso.gevent.Model.Gestion;
import com.kalanso.gevent.Service.GestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion")
public class GestionController {

    @Autowired
    private GestionService gestionService;

    @PostMapping
    public ResponseEntity<Gestion> createGestion(@RequestBody Gestion gestion) {
        Gestion savedGestion = gestionService.saveGestion(gestion);
        return ResponseEntity.ok(savedGestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gestion> getGestionById(@PathVariable Long id) {
        Gestion gestion = gestionService.getGestionById(id);
        return ResponseEntity.ok(gestion);
    }

    @GetMapping
    public ResponseEntity<List<Gestion>> getAllGestions() {
        List<Gestion> gestions = gestionService.getAllGestions();
        return ResponseEntity.ok(gestions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gestion> updateGestion(@PathVariable Long id, @RequestBody Gestion gestionDetails) {
        Gestion updatedGestion = gestionService.updateGestion(id, gestionDetails);
        return ResponseEntity.ok(updatedGestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGestion(@PathVariable Long id) {
        gestionService.deleteGestion(id);
        return ResponseEntity.ok("Gestion supprimée avec succès");
    }
}

