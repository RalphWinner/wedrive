package com.wedrive.controller;

import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public void SendingEMail(String subject, String text, String receiver, String fullname) {

        final String username = "ralphmppwinner@gmail.com";
        final String password = "jtrngjnvccwxkelj";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("wedrivempp@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(receiver)
            );
            message.setSubject(subject);
            message.setText("Dear " + fullname + ", "
                    + text
                    + "\n\n Thanks, "
                    + "\n\n WeDrive MPP project (2022)");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
