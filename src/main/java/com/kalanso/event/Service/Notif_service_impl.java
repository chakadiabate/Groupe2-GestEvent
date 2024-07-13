package com.kalanso.event.Service;


import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Repository.Notification_repo;
import org.apache.pdfbox.pdmodel.PDDocument;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;



import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class Notif_service_impl implements Notification_service {

    private Notification_repo notificationRepo;
    private JavaMailSender javaMailSender;
    private QRCodeService qrCodeService;

    public void SendMail(Notification notification) throws MessagingException, IOException, DocumentException, WriterException{


        String qrCodeText = generateRandomString();

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

        String Content_Qrcode = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Open Sans', Arial, sans-serif;\n" +
                "            background-color: #141414;\n" +
                "            color: #e0e0e0;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #1f1f1f;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .ticket-container {\n" +
                "            background-color: #2c2c2c;\n" +
                "            border-radius: 10px 10px 0 0;\n" +
                "            padding: 10px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .ticket{\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        .ticket-container img {\n" +
                "            max-width: 150px;\n" +
                "            height: auto;\n" +
                "            max-height: 150px;\n" +
                "            margin-right: 20px;\n" +
                "        }\n" +
                "        .ticket-details {\n" +
                "            display: block;\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            text-align: center;\n" +
                "            color: #888;\n" +
                "            font-size: 12px;\n" +
                "            padding: 5px;\n" +
                "            border-radius: 0 0 10px 10px;\n" +
                "            background-color: #2c2c2c;\n" +
                "        }\n" +
                "        @media (max-width: 600px) {\n" +
                "            .container {\n" +
                "                padding: 5px;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"ticket-container\">\n" +
                "            <h2>[Titre Event]</h2>\n" +
                "            <div class=\"ticket\">\n" +
                "                <img src='cid:qrcode' alt=\"Code QR du Ticket\"></img>\n" +
                "                <div class=\"ticket-details\">\n" +
                "                    <p>Nom : [Nom]</p>\n" +
                "                    <p>Email : [Email]</p>\n" +
                "                    <p>Date : [Date]</p>\n" +
                "                    <p>Numéro de Ticket : 123456789</p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            <p>&copy; 2024 Votre Entreprise. Tous droits réservés.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true) ;
        helper.setTo(notification.getDest_email());
        helper.setSubject(notification.getSujet());
        helper.setSentDate(notification.getDateEnvoi());
        helper.setText(Content_Qrcode, true);
        helper.addInline("qrcode", qrCodeSource, "image/png");
        System.out.println("hello");

        byte[] pdfBytes = generatePdfFromHtml(Content_Qrcode);

        // Convert PDF to image
        byte[] imageBytes = generateImageFromPdf(pdfBytes);

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
        return null;
    }

    @Override
    public Notification Afficher(Notification notification) {
        return null;
    }

    @Override
    public Notification Delete(Notification notification) {
        return null;
    }

    @Override
    public Notification Update(Notification notification) {
        return null;
    }

    private byte[] generatePdfFromHtml(String html) throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        org.xhtmlrenderer.pdf.ITextRenderer renderer = new org.xhtmlrenderer.pdf.ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
        return outputStream.toByteArray();
    }

    private byte[] generateImageFromPdf(byte[] pdfBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(pdfBytes);
        PDDocument document = PDDocument.load(inputStream);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage image = pdfRenderer.renderImageWithDPI(0, 300); // Render the first page with 300 DPI

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        document.close();

        return outputStream.toByteArray();
    }

    public byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        hints.put(EncodeHintType.MARGIN, 1); // Reduce margin to 1
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        javax.imageio.ImageIO.write(bufferedImage, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }
    public String generateRandomString() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789&é(-è_çà)=#{|!§/:?%µ£@]}[";
        int LENGTH = 26;
        Random RANDOM = new SecureRandom();

        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}

