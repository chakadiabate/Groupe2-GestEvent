package com.kalanso.event.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Notification;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface Notification_service {

    //Methode pour envoyer un message;
    void SendMail (Notification notification) throws MessagingException, IOException, DocumentException, WriterException;

    //Methode pour ajouter une notification à la BD.
    Notification Ajouter (Notification notification);

    //Methode pour Afficher une notification à la BD.
    Notification Afficher (Notification notification);

    //Methode pour supprimer une notification à la BD.
    Notification Delete (Notification notification);

    //Methode pour mis à jour une notification à la BD.
    Notification Update (Notification notification);
}
