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

public class mailfns extends fnssanitycheck {
	public static void sendemail(String value,String testdata_aug,String resp_time) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("demo.mcaas@gmail.com","happiest@123");
				}
			});

		try {

			Message message = new MimeMessage(session);
			//message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
			message.setFrom(new InternetAddress("demo.mcaas@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
			//InternetAddress.parse("qa_mcaas@happiestminds.onmicrosoft.com"+","+"Rakesh.Guttedar@happiestminds.com"+","+"prashantha.hl@happiestminds.com"+","+"sriram.hl@happiestminds.com"+","+"mallikarjuna.b@happiestminds.com"+","+"senthamizhan.p@happiestminds.com"));
			InternetAddress.parse("sudhakar.koduri@happiestminds.onmicrosoft.com"+","+"sudhakar4@gmail.com"));
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
					"<p/> "+value+
					"<p>"+"Aug search keyword"+testdata_aug+
					"<p>"+"Aug resposnetime"+resp_time+
					"<p/> "+"Reprint URL: https://reprints.forrester.com/#/assets/2/184/'RES118088'/reports?DummyParameter=TEST"+
					"<p/>"+value+
					"<p/> "+"TEI report URL: https://studies.totaleconomicimpact.com/#/assets/5/servicenow/costsavings/tei?DummyParameter=TEST"+
					"<p/>"+value+
					"<p/>"+"Kindly use valid credentials to access MindFields Basic report : http://research.mindfields.net.au/#/assets/6/458/'MFRPAB'/reports?email=Grant.Crawford@ventia.com.au&fname=Grant&lname=Crawford&role=reader"+
					"<p/>"+value+
					"<p/>"+"Kindly use valid credentials to access MindFields Premium report : http://research.mindfields.net.au/#/assets/6/523/%27MFRPA%27/reports?email=Grant.Crawford@ventia.com.au&fname=Grant&lname=Crawford&role=reader","text/html");
			Transport.send(message);
			System.out.println("Mail sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}


