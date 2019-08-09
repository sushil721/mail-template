package com.paxcel.mail.components;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.paxcel.mail.common.ChildChecker;
import com.paxcel.mail.components.interfc.ComponentInterface;
import com.paxcel.mail.model.DomainModel;

@Component("Advertisement")
public class Advertisement implements ComponentInterface {
	
	private static Logger log = LoggerFactory.getLogger(Advertisement.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;

	@Override
	public Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException {

		log.info("in Advertisement for creating a div");
	    writer.append("<div class=\"lg-"+domainModel.getProperties().get("lg")+"\" id=\""+domainModel.getComponentId()+"\" >\r\n" );
		writer.append("<span style=\"display:inline\">"+domainModel.getLabel()+" : "+domainModel.getBinding()+"</span>");
			  if(childChecker.checkChild(domainModel.getChildren().size())) {
				for(DomainModel dm:domainModel.getChildren()) {
				  ComponentInterface component = (ComponentInterface)context.getBean(dm.getType()); 
				  component.getGeneratedView(writer,dm);
				}//for loop     
			 }//if child checker
		writer.append("</div>\r\n" );
		
		return writer;
	}

}
