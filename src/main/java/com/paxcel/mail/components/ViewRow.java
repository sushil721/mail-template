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

@Component("ViewRow")
public class ViewRow  implements ComponentInterface {
	
private static Logger log = LoggerFactory.getLogger(ViewRow.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;

	/*
	 * @Autowired private ComponentInterface compInterface;
	 */
	public Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException {
		log.info("In ViewRow for creating a table");
		writer.append("<tr class=\"lg-"+domainModel.getProperties().get("lg")+"\">\r\n" );
		
		 if(childChecker.checkChild(domainModel.getChildren().size())) {
			for(DomainModel dm:domainModel.getChildren()) {
			   ComponentInterface component = (ComponentInterface) context.getBean(dm.getType());
			   component.getGeneratedView(writer,dm);
			 }//for loop
		}//if child checker
			
		writer.append("</tr>\r\n" );
	  return writer;
	}
	
}
