package com.paxcel.mail.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
//import org.thymeleaf.spring4.SpringTemplateEngine;

import com.paxcel.mail.model.Mail;

@Service
public class EmailServiceHtmlGeneration {
	
	    @Autowired
	    private JavaMailSender emailSender;

	   // @Autowired
	   // private SpringTemplateEngine templateEngine;

	    public void sendGeneratedMail(Mail mail, String HTML_CONTENT) throws MailSendException , MessagingException, IOException {
	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());
	        
	        helper.setTo(mail.getTo());
	        helper.setText(HTML_CONTENT, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());

	        emailSender.send(message);
	    }

		
}
