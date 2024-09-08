package com.org.service;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class EmailService {

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        String from = "your_email@example.com";
        String host = "smtp.example.com"; // Use your SMTP server

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587"); // Add the SMTP port
        properties.setProperty("mail.smtp.auth", "true"); // Enable authentication
        properties.setProperty("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        // Create an authenticator
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your_email@example.com", "your_password");
            }
        };

        jakarta.mail.Session session = Session.getInstance(properties, auth);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }
}
