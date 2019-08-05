package com.paxcel.mail.service;

import java.io.IOException;
import java.io.Writer;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.paxcel.mail.model.DomainModel;

public interface HtmlGenerateServiceInterface {

	//Writer createHtmlTags(ModelMain modelMain);

	Writer createHtmlTags(Writer writer, DomainModel domainModel)  throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchBeanDefinitionException;

}
