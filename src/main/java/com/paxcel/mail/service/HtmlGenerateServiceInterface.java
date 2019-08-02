package com.paxcel.mail.service;

import java.io.IOException;
import java.io.Writer;

import com.paxcel.mail.model.ModelMain;

public interface HtmlGenerateServiceInterface {

	//Writer createHtmlTags(ModelMain modelMain);

	Writer createHtmlTags(Writer writer, ModelMain modelMain)  throws IOException,ClassNotFoundException, InstantiationException, IllegalAccessException;

}
