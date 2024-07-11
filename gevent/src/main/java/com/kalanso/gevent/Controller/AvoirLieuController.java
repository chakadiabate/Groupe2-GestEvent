package com.kalanso.gevent.Controller;

import com.kalanso.gevent.Model.AvoirLieu;
import com.kalanso.gevent.Service.AvoirLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avoirlieu")
public class AvoirLieuController {

    @Autowired
    private AvoirLieuService avoirLieuService;

    @PostMapping
    public ResponseEntity<AvoirLieu> createAvoirLieu(@RequestBody AvoirLieu avoirLieu) {
        AvoirLieu savedAvoirLieu = avoirLieuService.saveAvoirLieu(avoirLieu);
        return ResponseEntity.ok(savedAvoirLieu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvoirLieu> getAvoirLieuById(@PathVariable Long id) {
        AvoirLieu avoirLieu = avoirLieuService.getAvoirLieuById(id);
        return ResponseEntity.ok(avoirLieu);
    }

    @GetMapping
    public ResponseEntity<List<AvoirLieu>> getAllAvoirLieux() {
        List<AvoirLieu> avoirLieux = avoirLieuService.getAllAvoirLieux();
        return ResponseEntity.ok(avoirLieux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvoirLieu> updateAvoirLieu(@PathVariable Long id, @RequestBody AvoirLieu avoirLieuDetails) {
        AvoirLieu updatedAvoirLieu = avoirLieuService.updateAvoirLieu(id, avoirLieuDetails);
        return ResponseEntity.ok(updatedAvoirLieu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAvoirLieu(@PathVariable Long id) {
        avoirLieuService.deleteAvoirLieu(id);
        return ResponseEntity.ok("Relation AvoirLieu supprimée avec succès");
    }
}

