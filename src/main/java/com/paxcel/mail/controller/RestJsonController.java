package com.paxcel.mail.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSendException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paxcel.mail.dto.MailResponceDTO;
import com.paxcel.mail.model.DomainModel;
import com.paxcel.mail.model.Mail;
import com.paxcel.mail.service.EmailServiceHtmlGeneration;
import com.paxcel.mail.service.HtmlGenerateServiceInterface;

@RestController
public class RestJsonController {
	
	 private static Logger log = LoggerFactory.getLogger(RestJsonController.class);
	 
	 @Autowired
	 private HtmlGenerateServiceInterface htmlGenerateServiceInterface;
	 
	 @Autowired
	 private EmailServiceHtmlGeneration emailServiceHtmlGeneration;
	 
     @GetMapping("/newJsonRequest")
     public MailResponceDTO emailTemplate( Model model) {
    	   log.info("Before Object Get ");
      Map<String, String> messageMap = new HashMap<String, String>();
      Writer writer = new StringWriter();
	   Resource resource = new ClassPathResource("/static/newjson.json");
	  // ModelMain modelMain = null;
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			DomainModel domainModel = mapper.readValue(resource.getInputStream(), DomainModel.class);
			//htmlGenerateServiceInterface.createHtmlTags(writer,modelMain).toString();

			Mail mail = new Mail();
			mail.setFrom("sushilgiacr@gmail.com");
			// mail.setTo("sushilneron@gmail.com");
			mail.setTo("sushil.singh@paxcel.net");
			//mail.setTo("preeti.gupta@paxcel.net");
			mail.setSubject("Ebill generated from ebill renderer.");
				try {
					
					emailServiceHtmlGeneration.sendGeneratedMail(mail, htmlGenerateServiceInterface.createHtmlTags(writer,domainModel).toString());
					
				} catch (MailSendException e) {
					log.error(e.getMessage());
					messageMap.put("Message", e.getMessage());
					return new MailResponceDTO(messageMap, HttpStatus.INTERNAL_SERVER_ERROR , "May be internate connection not available");
				} catch (MessagingException e) {
					log.error(e.getMessage());
					messageMap.put("Message", e.getMessage());
					return new MailResponceDTO(messageMap, HttpStatus.BAD_GATEWAY , null);
				}catch (NoSuchBeanDefinitionException e) {
					log.error(e.getMessage());
					messageMap.put("Message", e.getMessage() +" ");
					return new MailResponceDTO(messageMap, HttpStatus.NOT_FOUND , " , please provide a required/valid 'type' ");
				} catch (ClassNotFoundException e) {
					log.error(e.getMessage());
					messageMap.put("Message", e.getMessage() +" type not accepted");
					return new MailResponceDTO(messageMap, HttpStatus.NOT_ACCEPTABLE , "Type Not Accept");
				} catch (InstantiationException e) {
					log.error(e.getMessage());
					messageMap.put("Message", e.getMessage() +" type not accepted");
					return new MailResponceDTO(messageMap, HttpStatus.NOT_FOUND, " class not instantiate");
				} catch (IllegalAccessException e) {
					log.error(e.getMessage());
					messageMap.put("Message", e.getMessage() +" type not accepted");
					return new MailResponceDTO(messageMap, HttpStatus.BAD_REQUEST , " Illegal Request");
				}
		} catch (IOException e) {
			log.error(e.getMessage());
			messageMap.put("Message", e.getMessage());
			return new MailResponceDTO(messageMap, HttpStatus.NOT_FOUND , null);
		}
		finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				messageMap.put("Message", e.getMessage());
				return new MailResponceDTO(messageMap, HttpStatus.NOT_FOUND , null);
			}
		}//finally
	    log.info("After Object Get ");
	    messageMap.put("Message","Mail sent successfully");
	    return new MailResponceDTO(messageMap, HttpStatus.OK , null);
    }

}
