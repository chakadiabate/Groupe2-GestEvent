package com.kalanso.event.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Repository.Evenement_repo;
import com.kalanso.event.Service.Notification.*;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class Event_service_impl implements Evenement_service {

    private Evenement_repo evenement_repo;
    private Notif_service_Evenement_impl notifServiceEvenementImpl;
    private Notif_service_Alert_impl notifServiceAlertImpl;
    private Notif_service_compteCrée_impl notifServiceCompteCrueImpl;
    private Notif_service_Reservation_impl notifServiceReservationImpl;

    @Override
    public String Ajout(Evenement evenement) {
        evenement_repo.save(evenement);
        Notification notification = new Notification();
        notification.setEvenement(evenement);
        notification.setDest_email("houatt0@gmail.com");
        notification.setSujet("Blablablablablablablablablablabla");
        try {
            notifServiceEvenementImpl.SendMail(notification);
            notifServiceCompteCrueImpl.SendMail(notification);
            notifServiceReservationImpl.SendMailTicket(notification);
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
        return "Evenement ajouter avec success";
    }

    @Override
    public List<Evenement> Afficher(Evenement evenement) {
        return List.of();
    }

    @Override
    public String Delete(Evenement evenement) {
        return "";
    }

    @Override
    public Evenement update(Evenement evenement) {
        return null;
    }
}
