package com.kalanso.event.Controller;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Service.Notification_service;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
@RestController
@RequestMapping("/notif")
@AllArgsConstructor
public class NotificationController {

    private Notification_service notificationService;

    @PostMapping("/send")
    public void SendMail(@RequestBody Notification notification) throws MessagingException, IOException, DocumentException, WriterException {
            notificationService.SendMail(notification);
    }

}
