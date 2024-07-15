package com.kalanso.event.Controller;

import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Service.Reservation_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/event/Reservation")
@AllArgsConstructor
public class ReservationController {


    private Reservation_service reservationService;

    @GetMapping("/Reserver")
    public String Reserver(Reservation reservation) {
        reservationService.Reserver(reservation);
        return "Reservation Effectué avec succès !!!";
    }
    @GetMapping("/ListReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
    @GetMapping("/AnnulerReservation")
    public String CancelReservation(Reservation reservation) {
        reservationService.AnnulerReservation(reservation);
        return "Reservation annulée avec succès!!!";
    }
}
