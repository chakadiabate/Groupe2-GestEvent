package com.kalanso.gevent.Controller;

import com.kalanso.gevent.Model.TypeTicket;
import com.kalanso.gevent.Service.TypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typetickets")
public class TypeTicketController {

    @Autowired
    private TypeTicketService typeTicketService;

    @PostMapping
    public ResponseEntity<TypeTicket> createTypeTicket(@RequestBody TypeTicket typeTicket) {
        TypeTicket savedTypeTicket = typeTicketService.saveTypeTicket(typeTicket);
        return ResponseEntity.ok(savedTypeTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeTicket> getTypeTicketById(@PathVariable Long id) {
        TypeTicket typeTicket = typeTicketService.getTypeTicketById(id);
        return ResponseEntity.ok(typeTicket);
    }

    @GetMapping
    public ResponseEntity<List<TypeTicket>> getAllTypeTickets() {
        List<TypeTicket> typeTickets = typeTicketService.getAllTypeTickets();
        return ResponseEntity.ok(typeTickets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeTicket> updateTypeTicket(@PathVariable Long id, @RequestBody TypeTicket typeTicketDetails) {
        TypeTicket updatedTypeTicket = typeTicketService.updateTypeTicket(id, typeTicketDetails);
        return ResponseEntity.ok(updatedTypeTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTypeTicket(@PathVariable Long id) {
        typeTicketService.deleteTypeTicket(id);
        return ResponseEntity.ok("Type de ticket supprimé avec succès");
    }
}

