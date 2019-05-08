package com.html.net;

import java.time.LocalDateTime;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendemailhtml {
	public static void sendemailtoteam(String value1,String value2,String value3,String value4,String value5,
    		String value6,String value7,String value8,String value9,
    		String value10,String value11,String value12,String value13,String value14,String value15,String value16,String value17) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		StringBuilder sb = new StringBuilder();
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
			message.setSubject("FnS Daily Sanity Test Results as on -"+" "+LocalDateTime.now());
			//message.setText("FnS Daily Sanity Test Results as on -"+" "+LocalDateTime.now());
			//LocalDateTime.now(),ZonedDateTime.now()
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
					"<p/><b>"+"Please find below Sanity Test Results for FnS Production Environment:"+"</b>"+
					"<table border ="+1+" cellpadding = "+5+" cellspacing = "+5+" bordercolor=green>"+
					"<tr>"+
					"<th bgcolor =lightblue>Test_Scenario</th>"+
					"<th bgcolor =lightblue>Test_Data</th>"+
					"<th bgcolor =lightblue>Response_Time</th>"+
					"<th bgcolor =lightblue>Result</th>"+
					"</tr>"+
					"<tr>"+
					"<td bgcolor =lightgreen rowspan = "+2+">KE</td>"+
					"<td>"+value1+"</td>"+
					"<td>"+value3+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					"<tr>"+
					"<td>"+value2+"</td>"+
					"<td>"+value4+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					"<tr>"+
					"<td bgcolor =lightgreen rowspan = "+2+">Aug_Search</td>"+
					"<td>"+value2+"</td>"+
					"<td>"+value3+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					"<tr>"+
					"<td>"+value2+"</td>"+
					"<td>"+value3+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					"<tr>"+
					"<td bgcolor =lightgreen>Full_Research_Load</td>"+
					"<td>"+value2+"</td>"+
					"<td>"+value3+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					"<tr>"+
					"<td bgcolor =lightgreen>PDF_Download</td>"+
					"<td>"+value2+"</td>"+
					"<td>"+value3+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					"<td bgcolor =lightgreen>Vault_Image_Capture</td>"+
					"<td>"+value2+"</td>"+
					"<td>"+value3+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					"</tr>"+
					"<td bgcolor =lightgreen>Vault_PDF_Download</td>"+
					"<td>"+value2+"</td>"+
					"<td>"+value3+"</td>"+
					"<td>"+value4+"</td>"+
					"</tr>"+
					/*"<p/> "+"Login Status"+value1+
					"<p/><b>"+"Knowledge Engine Test Results:"+"</b>"+
					"<p/> "+"KE Input Keyword1:"+value2+
					"<p/>"+"Response Time:"+value4+
					"<p/>"+"KE Input Keyword2:"+value3+
					"<p/>"+"Response Time:"+value5+
					"<p/><b>"+"Aug Search Test Results:"+"</b>"+
					"<p/>"+"Aug search keyword1:"+value6+
					"<p/>"+"Response time:"+value8+
					"<p/>"+"Aug search keyword2:"+value7+
					"<p/>"+"Response time:"+value9+
					"<p/><b>"+"Research Loading and PDF Download in Research Page Test Results:"+"</b>"+
					"<p/> "+"AssetID:"+value10+
					"<p/>"+"Full Research Loading Time:"+value11+
					"<p/>"+"PDF File Successfully Downloaded:"+value12+
					"<p/>"+"Time Taken for Research PDF to get Downloaded:"+value13+
					"<p/><b>"+"VAULT Test Results:"+"</b>"+
					"<p/> "+"AssetID:"+value14+
					"<p/>"+"Time Taken for Image to get saved to VAULT:"+value15+
					"<p/> "+"VAULT PDF Successfully Downloaded:"+value16+*/
					//"<p/>"+"Time Taken for VAULT PDF to get Downloaded:"+value17+
					"</table>"+""+"",
					"text/html");
			
			Transport.send(message);
			System.out.println("Mail sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}  
}
