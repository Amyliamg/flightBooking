package com.example.flightbooking.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtilImpl implements EmailUtil {

    @Autowired
    JavaMailSender sender;

    @Override
    public void sendEmail(String to, String subject, String body, String attachmentPath) {
        // MIME: Multipurpose Internet Mail Extensions
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.addAttachment("Itinerary", new File(attachmentPath)); // add the attachment document to the email
            helper.setText(body);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        sender.send(message);
    }
}