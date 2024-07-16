package com.kalanso.event.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Model.StatutReservation;
import com.kalanso.event.Repository.Reservation_repo;
import com.kalanso.event.Repository.StatutRepo;
import com.kalanso.event.Service.Notification.Notif_serviceTicket_impl;
import com.kalanso.event.Service.Notification.Notif_service_Reservation_impl;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class Reservation_serviceImpl implements Reservation_service {

    private final Notif_serviceTicket_impl notif_serviceTicket_impl;
    private Reservation_repo reservationRepo;
    private Notif_service_Reservation_impl notifServiceReservationImpl;
    private StatutRepo statutRepo;
    private ContexHolder contexHolder;

    @Override
    public Reservation Reserver(Reservation reservation) {
        Notification notification = new Notification();
        notification.setDest_email(contexHolder.utilisateur().getEmail());
        notification.setSujet("Reservation de ticket");
        notification.setUtilisateur(contexHolder.utilisateur());
        notification.setEvenement(reservation.getEvenement());
        try {
            notifServiceReservationImpl.sendMailWelcome(notification);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        reservation.setDate_res(new Date());

        if (reservation.getEvenement().getTypeEvent().getNom() == "PAYANT" ){
            try {
                notifServiceReservationImpl.SendMailTicket(notification);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (WriterException e) {
                throw new RuntimeException(e);
            }
        }
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
