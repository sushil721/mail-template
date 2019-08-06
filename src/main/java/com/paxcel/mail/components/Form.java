package com.paxcel.mail.components;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.paxcel.mail.common.ChildChecker;
import com.paxcel.mail.common.TableCounterChecker;
import com.paxcel.mail.components.interfc.ComponentInterface;
import com.paxcel.mail.model.DomainModel;

@Component("Form")
public class Form  implements ComponentInterface {
	
	private static Logger log = LoggerFactory.getLogger(Form.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;
	
	 @Autowired 
	 private TableCounterChecker counterChecker;

	public Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException {

		log.info("in Form for creating a table");
		  writer.append("<table class=\"lg-"+domainModel.getProperties().get("lg")+"\">\r\n" );
		
		 if(childChecker.checkChild(domainModel.getChildren().size())) {
			
			for(DomainModel dm:domainModel.getChildren()) {
				
			   ComponentInterface component = (ComponentInterface) context.getBean(dm.getType());
				//ComponentInterface component = new Container();
			   component.getGeneratedView(writer,dm);
			  // System.out.println("IN Form ");
			}//for loop
			
		}//if child checker
		 counterChecker.reSet();
		writer.append("</table>\r\n" );
			
		return writer;
	}
}
