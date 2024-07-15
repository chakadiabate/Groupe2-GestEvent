package com.kalanso.event.Service;

import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Model.StatutReservation;
import com.kalanso.event.Repository.Reservation_repo;
import com.kalanso.event.Repository.StatutRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Reservation_serviceImpl implements Reservation_service {

    private Reservation_repo reservationRepo;
    private StatutRepo statutRepo;


    public Reservation_serviceImpl(Reservation_repo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public Reservation Reserver(Reservation reservation) {
         reservation.setDate_res(new Date());
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation AnnulerReservation(Reservation reservation, String Statut) {
        StatutReservation statutReservation = statutRepo.findByStatut(Statut);
        reservation.setStatut(statutReservation);
        return reservationRepo.save(reservation);
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }
}
