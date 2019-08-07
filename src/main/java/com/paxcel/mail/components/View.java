package com.paxcel.mail.components;

import java.io.Writer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.paxcel.mail.components.interfc.ComponentInterface;
import com.paxcel.mail.model.DomainModel;

@Primary
@Component("View")
public class View implements ComponentInterface {
	
	/*
	 * @Autowired private ChildChecker childChecker;
	 */
	public Writer getGeneratedView(Writer writer, DomainModel domainModelNew) {

	return writer;
	}

}
