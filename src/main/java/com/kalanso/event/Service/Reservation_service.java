package com.kalanso.event.Service;

import com.kalanso.event.Model.Reservation;

import java.util.List;

public interface Reservation_service {
    Reservation Reserver(Reservation reservation);
    Reservation AnnulerReservation(Reservation reservation);
    List<Reservation> getAllReservations();
}
