package com.one.Shout.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	 public void sendingMail(String to, String subject, String body) throws MessagingException {
		    MimeMessage message=javaMailSender.createMimeMessage();
		    MimeMessageHelper helper;
		    helper=new MimeMessageHelper(message,true);
		    helper.setTo(to);
		    helper.setSubject(subject);
		    helper.setText(body);
		    System.out.println("inside method service---=-=-===========================");
		    javaMailSender.send(message);
		 }
}
