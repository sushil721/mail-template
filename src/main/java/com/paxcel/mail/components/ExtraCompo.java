package com.paxcel.mail.components;

import java.io.Writer;

import org.springframework.stereotype.Component;

import com.paxcel.mail.components.interfc.ComponentInterface;
import com.paxcel.mail.model.DomainModel;

@Component("ExtraCompo")
public class ExtraCompo  implements ComponentInterface{
	
	/*
	 * @Autowired private ChildChecker childChecker;
	 */
	@SuppressWarnings("unused")
	public Writer getGeneratedView(Writer writer, DomainModel domainModelNew) {

		//String str = "<div class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n";
		
		 // if(childChecker.checkChild(domainModelNew.getChildren().size())) {
			  
			//  for(DomainModel dm:domainModelNew.getChildren()) {
				//str.concat("Sushil Kumar Singh");  
				System.out.println("In Container");
			 // }
		    // }
		 //  str.concat("</div>\r\n");
		return writer;
	}

}
