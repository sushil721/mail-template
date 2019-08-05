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

@Component("Currency")
public class Currency  implements ComponentInterface{
	
	private static Logger log = LoggerFactory.getLogger(Currency.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;

	public Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException {

		log.info("in Currency for creating a table");
	    writer.append("<div class=\"md-"+domainModel.getProperties().get("md")+"\">\r\n" );
		  writer.append("<span style=\"display:inline\">"+domainModel.getLabel()+" : "+domainModel.getBinding()+"</span>");
		writer.append("</div>\r\n" );
			
		return writer;
	}



}
