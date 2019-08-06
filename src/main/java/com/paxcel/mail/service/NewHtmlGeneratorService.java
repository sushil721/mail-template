package com.paxcel.mail.service;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.paxcel.mail.common.ChildChecker;
import com.paxcel.mail.components.interfc.ComponentInterface;
import com.paxcel.mail.model.DomainModel;

@Service
@Primary
public class NewHtmlGeneratorService implements HtmlGenerateServiceInterface {

	
	private static Logger log = LoggerFactory.getLogger(HtmlGeneratorService.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;
	
	@Override
	public Writer createHtmlTags(Writer writer, DomainModel domainModel) throws IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, NoSuchBeanDefinitionException {
		writer.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				".lg-1 {\r\n" + 
				"	width: 8.33%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-2 {\r\n" + 
				"	width: 16.66%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-3 {\r\n" + 
				"	width: 25%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-4 {\r\n" + 
				"	width: 33.33%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-5 {\r\n" + 
				"	width: 41.66%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-6 {\r\n" + 
				"	width: 50%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-7 {\r\n" + 
				"	width: 58.33%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-8 {\r\n" + 
				"	width: 25%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-9 {\r\n" + 
				"	width: 75%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-10 {\r\n" + 
				"	width: 83.33%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-11 {\r\n" + 
				"	width: 91.66%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".lg-12 {\r\n" + 
				"	width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".summaryContainer {\r\n" + 
				"	border: 1px solid black;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".summaryContainer .container-title {\r\n" + 
				"	font-weight: bold\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".amountDueContainer {\r\n" + 
				"	border: 1px solid black;\r\n" + 
				"	background-color: #9dcfe6\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".amountDueContainer div {\r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".caption {\r\n" + 
				"	text-align: left;\r\n" + 
				"	padding: 5px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".underlined-caption caption {\r\n" + 
				"	border-bottom: 1px solid black;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".outer {\r\n" + 
				"	background: #ffffff;\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	width: 600px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"table {\r\n" + 
				"	border-spacing: 0px;\r\n" + 
				"	padding: 5px\r\n" + 
				"}\r\n" +
			    "div {\r\n" + 
				"	margin-bottom: 15px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n");
		
		writer.append("<body style=\"background-color:#f6f6f6;\">\r\n" + 
					  "<center>\r\n" + 
					  "<table width=\"600px\" class=\"outer\">\r\n");
		
		if(childChecker.checkChild(domainModel.getChildren().size())) {
			
			for(DomainModel dm:domainModel.getChildren()) {
				
			   ComponentInterface component = (ComponentInterface) context.getBean(dm.getType());
			   component.getGeneratedView(writer,dm);
			   
			}//for loop
			
			}//if child checker
		
		writer.append("</table>\r\n" + 
					  "</center>\r\n" + 
					  "</body>\r\n");
		writer.append("</html>");
	    System.out.println(writer.toString());
		return writer;
	}

}
