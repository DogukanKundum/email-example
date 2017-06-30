package com.dogukan.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String username = "to-username";
        final String password = "to-password";

//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");

        Properties props = new Properties();
		
		props.put("mail.smtp.host", "10.25.101.13");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.transport.protocol", "smtp");
		
		//props.put("mail.smtp.socketFactory.port", "587");
		//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("to-email"));
            message.setSubject("Testing Subject");
            message.setText("Dear NAME SURNAME," 
					+ "\n\n This is test mail!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}

}
