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

@Component("Image")
public class Image  implements ComponentInterface {
	
	private static Logger log = LoggerFactory.getLogger(Image.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;

	//private static StringBuilder sb = new StringBuilder("");
	
	public Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException {

		  log.info("in Container Row for creating a table");
		  writer.append("<div class=\"lg-"+domainModel.getProperties().get("lg")+"\">");
		 // sb.append(domainModel.getAltText()==null ? "" : domainModel.getAltText());
		  writer.append("<img src=\""+domainModel.getSrc()+"\" alt=\""+domainModel.getAltText()+"\" width=\""+domainModel.getWidth()+"\" />\r\n" );
		  
		  if(childChecker.checkChild(domainModel.getChildren().size())) {
			  for(DomainModel dm:domainModel.getChildren()) {
			  ComponentInterface component = (ComponentInterface)
			  context.getBean(dm.getType()); 
			  component.getGeneratedView(writer,dm);
			  System.out.println("IN Container Row "); }//for loop
			 
		}//if child checker
		  writer.append("</div>");
		
		return writer;
	}

}
