package com.mail;

import java.util.Properties;

import javax.mail.Session;

package com.journaldev.mail;

import java.util.Properties;

import javax.mail.Session;

public class Email {
	
	public static void main(String[] args) {
		
	    System.out.println("Email");
		
	    String smtpHostServer = "smtp.example.com";
	    String emailID = "email_me@example.com";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    EmailUtil.sendEmail(session, emailID,"Email Testing Subject", "Email Testing Body");
	}

}