package com.kalanso.event.Service;


import com.google.zxing.WriterException;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Repository.Notification_repo;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class Notif_service_Evenement_impl implements Notification_service {

    private Notification_repo notificationRepo;
    private JavaMailSender javaMailSender;
    private QRCodeService qrCodeService;
    private generatePdfFromHtml generatePdfFromHtml;
    private GenerateImageFromPdf generateImageFromPdf;
    private GenerateRandomString generateRandomString;

    public void SendMail(Notification notification) throws MessagingException, IOException, DocumentException, WriterException{


        String qrCodeText = generateRandomString.generateRandomString();

        byte[] qrCodeImage = qrCodeService.generateQRCode(qrCodeText, 250, 250);
        InputStreamSource qrCodeSource = new ByteArrayResource(qrCodeImage);

        String content ="<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
            "<style>" +
                "body {font-family: 'Roboto', sans-serif; background-color: #ffffff; color: #fff; width: 100vw; height: 100vh; display: flex; justify-content: center; align-content: center; align-items: center;}" +
                ".container { max-width: 600px; margin: auto; padding: 20px; background-color: #1f1f1f; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); }" +
                ".header { background-color: #ff7000; padding: 20px; border-radius: 10px 10px 0 0; text-align: center; }" +
                ".header h1 { margin: 0; font-size: 24px; }" +
                ".content { padding: 20px; }" +
                ".content p { line-height: 1.6; }" +
                ".footer { text-align: center; color: #888; font-size: 12px; padding: 10px; border-radius: 0 0 10px 10px; background-color: #2c2c2c; }" +
            "</style>" +
        "</head>" +
        "<body>" +
            "<div class='container'>" +
                "<div class='header'>" +
                    "<h1>Bienvenue, [Nom]!</h1>" +
                "</div>" +
                "<div class='content'>" +
                    "<p>Merci de vous être inscrit à notre service. Nous sommes ravis de vous avoir avec nous.</p>" +
                    "<p>Profitez de nos fonctionnalités et faites-nous savoir si vous avez des questions.</p>" +
                "</div>" +
                "<div class='footer'>" +
                    "<p>&copy; 2024 Votre Entreprise. Tous droits réservés.</p>"+
                "</div>" +
            "</div>" +
        "</body>" +
        "</html>";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true) ;
        helper.setTo(notification.getDest_email());
        helper.setSubject(notification.getSujet());
        helper.setSentDate(notification.getDateEnvoi());
        helper.setText(content, true);
        helper.addInline("qrcode", qrCodeSource, "image/png");
        System.out.println("hello");

        byte[] pdfBytes = generatePdfFromHtml.generatePdfFromHtml(content);

        // Convert PDF to image
        byte[] imageBytes = generateImageFromPdf.generateImageFromPdf(pdfBytes);

        // Add PDF attachment
        InputStreamSource pdfSource = new ByteArrayResource(pdfBytes);
        helper.addAttachment("ticket.pdf", pdfSource);

        // Add image attachment
        InputStreamSource imageSource = new ByteArrayResource(imageBytes);
        helper.addAttachment("ticket.png", imageSource);

        helper.addAttachment("qrcode.png", qrCodeSource);

        javaMailSender.send(message);
        notificationRepo.save(notification);
    }

    @Override
    public Notification Ajouter(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public List<Notification> Afficher() {
        return notificationRepo.findAll();
    }

    @Override
    public String Delete(Integer id) {
        notificationRepo.deleteById(id);
        return "Votre notification a ete supprimee avec succes";
    }

}

