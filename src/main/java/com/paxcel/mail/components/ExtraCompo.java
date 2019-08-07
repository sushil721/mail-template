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
	public Writer getGeneratedView(Writer writer, DomainModel domainModelNew) {

		
		return writer;
	}

}
