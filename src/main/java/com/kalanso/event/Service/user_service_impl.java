package com.kalanso.event.Service;


import com.kalanso.event.Model.Admin;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Model.Utilisateur;
import com.kalanso.event.Repository.Notification_repo;
import com.kalanso.event.Repository.Utilisateur_repo;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class user_service_impl implements Utilisateur_service {

    private Utilisateur_repo utilisateurRepo;

    @Override
    public Admin Ajout(Admin admin) {
        return utilisateurRepo.save(admin);
    }

    @Override
    public List<Utilisateur> update(String id) {
        return null;
    }
}
