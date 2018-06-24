package br.hackaton.java.service.impl;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.hackaton.java.entity.Email;
import br.hackaton.java.service.EmailService;

/**
 * Reference: https://www.journaldev.com/2532/javamail-example-send-mail-in-java-smtp
 */
public class EmailServiceImpl implements EmailService{

	public void contactUs(Email email) {
		
		// TODO - TO TEST IS NECESSARY PUT CORRECT EMAIL
		final String fromEmail = "XXX@gmail.com"; //requires valid gmail id
		// TODO - TO TEST IS NECESSARY PUT CORRECT PASSWORD
		final String password = "XXXXX"; // correct password for gmail id
		final String toEmail = "XXX@gmail.com"; // can be any email id 

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		
	    sendEmail(session, toEmail,email.getSubject(), email.getBody());

	}
	

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	private void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("biafreire2611@gmail.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("biafreire2611@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      //e.printStackTrace();
	    	e.getMessage();
	    	// It will not interrupy process. It is just a test. It is necessary add email, pass
	    }
	}
}
