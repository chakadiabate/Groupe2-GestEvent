package com.kalanso.event.Controller;

import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Service.Reservation_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/gestEvent/event/Reservation")
@AllArgsConstructor
public class ReservationController {


    private Reservation_service reservationService;

    @PostMapping("/Reserver")
    public String Reserver(@RequestBody Reservation reservation) {
        reservationService.Reserver(reservation);
        return "Reservation Effectué avec succès !!!";
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/ListReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PutMapping("/AnnulerReservation")
    public String CancelReservation(@RequestBody Reservation reservation, @RequestBody String Statut) {
        reservationService.AnnulerReservation(reservation, Statut);
        return "Reservation annulée avec succès!!!";
    }
}
