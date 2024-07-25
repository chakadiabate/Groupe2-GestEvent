package com.kalanso.event.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Model.RoleUser;
import com.kalanso.event.Model.Utilisateur;
import com.kalanso.event.Repository.Evenement_repo;
import com.kalanso.event.Repository.RoleUserRepo;
import com.kalanso.event.Repository.Utilisateur_repo;
import com.kalanso.event.Service.Notification.*;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class Event_service_impl implements Evenement_service {

    private Evenement_repo evenement_repo;
    private Notif_service_Evenement_impl notifServiceEvenementImpl;
    private Utilisateur_repo utilisateur_repo;
    private RoleUserRepo roleUserRepo;

    @Override
    public String Ajout(Evenement evenement) {
        evenement_repo.save(evenement);
        RoleUser roleUser = roleUserRepo.findByRole("ADMIN");
        List<Utilisateur> Utilisateurs = utilisateur_repo.findByRole(roleUser);

        Utilisateurs.forEach(p->{
            Notification notification = new Notification();
            notification.setEvenement(evenement);
            notification.setSujet("Ajout d'évènement");
            notification.setDest_email(p.getEmail());

            try {
                notifServiceEvenementImpl.SendMail(notification);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (WriterException e) {
                throw new RuntimeException(e);
            }
        });
        return "Evenement ajouter avec success";
    }

    @Override
    public List<Evenement> Afficher(Evenement evenement) {
        return evenement_repo.findAll();
    }

    @Override
    public String Delete(Evenement evenement) {
        evenement_repo.delete(evenement);
        return "Event deleted with succes";
    }

    @Override
    public Evenement update(Integer id, Evenement evenement) {
        return evenement_repo.findById(id)
                .map(p->{
                    p.setNom(evenement.getNom());
                    p.setDescription(evenement.getDescription());
                    p.setCategory(evenement.getCategory());
                    p.setDatedebut(evenement.getDatedebut());
                    p.setDatefin(evenement.getDatefin());
                    p.setDerouler(evenement.getDerouler());
                    p.setNombrePlace(evenement.getNombrePlace());
                    return evenement_repo.save(p);
                }).orElseThrow(()-> new RuntimeException("The event couldn't be deleted "));
    }
}
