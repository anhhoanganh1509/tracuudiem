package vn.springhibernate.hoanganh.controller;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class MailUtil {
	private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
    private static final String SMTP_AUTH_USER = "anhhoanganh1509";
    private static final String SMTP_AUTH_PWD = "Hoang123@";

    /*public static void main(String[] args) throws Exception{
        new MailUtil().SendMail();
    }*/

    public void SendMail() throws Exception
    {
       Properties properties = new Properties();
          properties.put("mail.transport.protocol", "smtp");
          properties.put("mail.smtp.host", SMTP_HOST_NAME);
          properties.put("mail.smtp.port", 587);
          properties.put("mail.smtp.auth", "true");
          // …
          Authenticator auth = new SMTPAuthenticator();
          Session mailSession = Session.getDefaultInstance(properties, auth);
          
          MimeMessage message = new MimeMessage(mailSession);
          Multipart multipart = new MimeMultipart("alternative");
          BodyPart part1 = new MimeBodyPart();
          part1.setText("Hello, Your Contoso order has shipped. Thank you, John");
          BodyPart part2 = new MimeBodyPart();
          part2.setContent("<p>Hello,</p><p>Your Contoso order has <b>shipped</b>.</p><p>Thank you,<br>John</br></p>","text/html");
          multipart.addBodyPart(part1);
          multipart.addBodyPart(part2);
          message.setFrom(new InternetAddress("anhhoanganh1509@gmail.com"));
          message.addRecipient(Message.RecipientType.TO,
             new InternetAddress("crhoang7@gmail.com"));
          message.setSubject("Your recent order");
          message.setContent(multipart);
          
          Transport transport = mailSession.getTransport();
	       // Connect the transport object.
	       transport.connect();
	       // Send the message.
	       transport.sendMessage(message, message.getAllRecipients());
	       // Close the connection.
	       transport.close();
    }
    
    private class SMTPAuthenticator extends javax.mail.Authenticator {
    	public PasswordAuthentication getPasswordAuthentication() {
    	   String username = SMTP_AUTH_USER;
    	   String password = SMTP_AUTH_PWD;
    	   return new PasswordAuthentication(username, password);
    	}
    }
    
}
