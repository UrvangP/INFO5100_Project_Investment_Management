/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author prathameshnemade
 */
public class SendEmail {

    private String to;
    private String from = "prathameshnemade95@gmail.com";
    private String host = "localhost";
    private Properties properties = System.getProperties();
    private Session session;
    private String subject;
    private String body;

    public SendEmail(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        this.session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vscode.book@gmail.com", "VSCode@123");
            }
        });
    }

    public void sendMail() {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(this.subject);
            message.setText(this.body);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
