package com.kalanso.event.Service;

import com.kalanso.event.Exception.ResourceNotFoundException;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Model.Lieu;
import com.kalanso.event.Repository.Evenement_repo;
import com.kalanso.event.Repository.Lieu_repo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Event_service_impl implements Evenement_service {

    private Evenement_repo evenement_repo;
    private Notification_service notificationService;

    @Override
    public Evenement Ajout(Evenement evenement) {
        return evenement_repo.save(evenement);
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
