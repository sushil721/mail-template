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

@Component("Container")
public class Container implements ComponentInterface{

	
	private static Logger log = LoggerFactory.getLogger(Container.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;
		
	/*
	 * @Autowired private TableCounterChecker counterChecker;
	 */
	public Writer getGeneratedView(Writer writer, DomainModel domainModel) throws IOException {
		TableCounterChecker counterChecker = new TableCounterChecker();
		log.info("in Container for creating a table");
	
//		System.err.println(domainModel.getType());
//		System.err.println(domainModel.getProperties().get("lg"));
		if(counterChecker.checkColumn(domainModel.getProperties().get("lg"))) {
			writer.append("<td class=\"lg-"+domainModel.getProperties().get("lg")+" " +domainModel.getCssClasses()+"\">\r\n");
			//System.out.println("In Table Data creation <td>");
	//logic start
			
			if(childChecker.checkChild(domainModel.getChildren().size())) {
				  for(DomainModel dm:domainModel.getChildren()) {
					  String title = domainModel.getTitle()==null ? " " : domainModel.getTitle();
					  writer.append("<table width=\"100%\">\r\n" + 
						 		"			<caption class=\"container-title\">"+title+"</caption>\r\n");
					 
					 ComponentInterface component= (ComponentInterface) context.getBean(dm.getType());
				     component.getGeneratedView(writer,dm); 
				     writer.append("</table>\r\n");
				    // System.out.println("IN Container ");
				  }//for loop 
		   }//if child checker
			
	//logic end		
			writer.append("</td>\r\n");
			//System.out.println("In Table Data close </td>");
			writer.append("</tr>\r\n");
			//System.out.println("In Table Row close </tr>");
			
		}else {
			writer.append("<tr>\r\n");
			//System.out.println("In Table Row creation <tr>");
			writer.append("<td class=\"lg-"+domainModel.getProperties().get("lg")+" " +domainModel.getCssClasses()+"\">\r\n");
			//System.out.println("In Table Data creation <td>");
	//logic start
			
			if(childChecker.checkChild(domainModel.getChildren().size())) {
				  for(DomainModel dm:domainModel.getChildren()) {
					 writer.append("<table width=\"100%\">\r\n" + 
					 		"			<caption class=\"container-title\">"+domainModel.getTitle()+"</caption>\r\n");
					 ComponentInterface component= (ComponentInterface) context.getBean(dm.getType());
				     component.getGeneratedView(writer,dm); 
				     
				     writer.append("</table>\r\n");
				     //System.out.println("IN Container ");
				  }//for loop 
		   }//if child checker
			
			
	//logic end		
			writer.append("</td>\r\n");
			//System.out.println("In Table Data close </td>");
			if(!childChecker.checkChild(domainModel.getChildren().size())) {
				writer.append("</tr>\r\n");
				//System.out.println("In Table Row close </tr>");
			}//inner childChecker if
		}//else
		
		return writer;
	}
	

}
