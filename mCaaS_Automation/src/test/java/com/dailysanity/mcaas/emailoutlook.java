package com.dailysanity.mcaas;

import java.time.ZonedDateTime;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

public class emailoutlook extends fnssanitycheck {
	public static void sendemail01(String value1,String testdata_aug,String resp_time) {
		Properties props = new Properties();
		/*props.put("mail.smtp.host", "outlook.office365.com");
		//props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.starttls.enable","true");
		//props.put("mail.smtp.socketFactory.class",
				//"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");*/
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.auth","true");
		 // props.put("mail.smtp.host","smtp.office365.com");
		  props.put("mail.smtp.host","smtp.office365.com");
		  //props.put("mail.pop.host","outlook.office365.com");
		  
		  props.put("mail.smtp.port","587");
		  //props.put("mail.imap.auth","true")
		 //props.put("mail.smtp.port","993");
		 // props.put("mail.pop.auth","true");
		 // props.put("mail.smtp.port","995");
		  props.put("mail.smtp.starttls.enable","true");
		  /*props.put("java.net.preferIPv4Stack" , "true");
		  props.put("mail.smtp.socketFactory.port", "587");
		  props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");*/
		 
		  //System.out.println("Test");
		  //props.put("mail.debug", "true");
		  

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("sudhakar.koduri@happiestminds.com","Kingkong123#");
				}
			});
//System.out.println("Test2");
		try {

			Message message = new MimeMessage(session);
			//message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
			message.setFrom(new InternetAddress("sudhakar.koduri@happiestminds.com"));
			//System.out.println("Test3");
			message.setRecipients(Message.RecipientType.TO,
			//InternetAddress.parse("qa_mcaas@happiestminds.onmicrosoft.com"+","+"Rakesh.Guttedar@happiestminds.com"+","+"prashantha.hl@happiestminds.com"+","+"sriram.hl@happiestminds.com"+","+"mallikarjuna.b@happiestminds.com"+","+"senthamizhan.p@happiestminds.com"));
			InternetAddress.parse("sudhakar4@gmail.com"));
			System.out.println("Test1");
			message.setSubject("FnS Sanity test results as on -"+" "+ZonedDateTime.now());
			/*message.setContent("Dear Team," +
					"\n\n "+"Please find below the Sanity test results for production urls Rendering status "+
					"\n\n "+output+
					"\n\n"+output1+
					"\n\n"+output2+
					"\n\n"+output3,"text/html");*/
			/*message.setText("Dear Team," +
			"\n\n "+"Please find below the Sanity test results for production urls Rendering status "+
			"\n\n "+output+
			"\n\n"+output1+
			"\n\n"+output2+
			"\n\n"+output3);*/
			message.setContent("Dear Team," +
					"<p/> "+"Please find below the Sanity test results for production urls Rendering status : "+
					"<p/> "+value1+
					"<p>"+"Aug search keyword"+testdata_aug+
					"<p>"+"Aug resposnetime"+resp_time+
					"<p/> "+"Reprint URL: https://reprints.forrester.com/#/assets/2/184/'RES118088'/reports?DummyParameter=TEST"+
					"<p/>"+value1+
					"<p/> "+"TEI report URL: https://studies.totaleconomicimpact.com/#/assets/5/servicenow/costsavings/tei?DummyParameter=TEST"+
					"<p/>"+value1+
					"<p/>"+"Kindly use valid credentials to access MindFields Basic report : http://research.mindfields.net.au/#/assets/6/458/'MFRPAB'/reports?email=Grant.Crawford@ventia.com.au&fname=Grant&lname=Crawford&role=reader"+
					"<p/>"+value1+
					"<p/>"+"Kindly use valid credentials to access MindFields Premium report : http://research.mindfields.net.au/#/assets/6/523/%27MFRPA%27/reports?email=Grant.Crawford@ventia.com.au&fname=Grant&lname=Crawford&role=reader","text/html");
			System.out.println("Test2");
			Transport.send(message);
			System.out.println("Test3");
			System.out.println("Mail sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

