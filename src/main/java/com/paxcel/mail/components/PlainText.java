package com.paxcel.mail.components;

import java.io.IOException;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.paxcel.mail.common.ChildChecker;
import com.paxcel.mail.components.interfc.ComponentInterface;
import com.paxcel.mail.model.DomainModel;

@Component("PlainText")
public class PlainText  implements ComponentInterface{
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;
	
	@SuppressWarnings("unused")
	public Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException {

		 writer.append("<div class=\"lg-"+domainModel.getProperties().get("lg")+" underlined-caption\">\r\n" );
		 writer.append("<span style=\"display:inline\">"+domainModel.getMessageKey()+"</span>");
		
		if(childChecker.checkChild(domainModel.getChildren().size())) {
			  for(DomainModel dm:domainModel.getChildren()) {
			  ComponentInterface component = (ComponentInterface)
			  context.getBean(dm.getType()); 
			  component.getGeneratedView(writer,dm);
			  System.out.println("IN Container Row "); }//for loop
			 
		}//if child checker
		 writer.append("</div>\r\n" );
		return writer;
	}
}
