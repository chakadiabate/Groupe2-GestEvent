package com.kalanso.event.Service;

import com.kalanso.event.Enumerations.StatutReservation;
import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Repository.Reservation_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Reservation_serviceImpl implements Reservation_service {
    final
    Reservation_repo reservationRepo;

    public Reservation_serviceImpl(Reservation_repo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public Reservation Reserver(Reservation reservation) {
         reservation.setDate_res(new Date());
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation AnnulerReservation(Reservation reservation) {
        reservation.setStatut(StatutReservation.ANNULEE);
        return reservationRepo.save(reservation);
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }
}
