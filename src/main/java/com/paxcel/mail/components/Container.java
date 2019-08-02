package com.paxcel.mail.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paxcel.mail.common.ChildChecker;
import com.paxcel.mail.model.DomainModel;

@Component
public class Container {

	@Autowired
	private ChildChecker childChecker;
	
	@SuppressWarnings("unused")
	public String getGeneratedView(DomainModel domainModelNew) {

		String str = "<div class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n";
		
		  if(childChecker.checkChild(domainModelNew.getChildren().size())) {
			  
			  for(DomainModel dm:domainModelNew.getChildren()) {
				str.concat("Sushil Kumar Singh");  
			  }
		     }
		   str.concat("</div>\r\n");
		return str;
	}
	
	

}
