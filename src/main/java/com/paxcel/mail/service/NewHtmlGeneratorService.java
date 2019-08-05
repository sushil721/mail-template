package com.paxcel.mail.service;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.paxcel.mail.common.ChildChecker;
import com.paxcel.mail.components.interfc.ComponentInterface;
import com.paxcel.mail.model.DomainModel;

@Service
public class NewHtmlGeneratorService implements HtmlGenerateServiceInterface {
	
	private static Logger log = LoggerFactory.getLogger(NewHtmlGeneratorService.class);
	
	@Autowired
	private ChildChecker childChecker;
	
	@Autowired
	private ApplicationContext context;

	/*
	 * @Autowired private ComponentInterface compInterface;
	 */
	@Override
	public Writer createHtmlTags(Writer writer, DomainModel domainModel) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException,NoSuchBeanDefinitionException {
		log.info("In maim Writer ");
		writer.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		writer.append("<html>\n");
		writer.append("<head><style type=\"text/css\">\n");
		writer.append("body {\r\n" + 
				"        background-color: #f6f6f6;\r\n" + 
				"        margin: 0 !important;\r\n" + 
				"        padding: 0;\r\n" + 
				"}\r\n" + 
				"table {\r\n" + 
				"		 border-spacing: 0px;\r\n" + 
				"         font-family: sans-serif;\r\n" + 
				"         color: #333333;\r\n" + 
				"	     table-layout: fixed;\r\n" + 
				"}\r\n" + 
				"td {\r\n" + 
				"          font-family: sans-serif;\r\n" + 
				"          font-size: 14px;\r\n" + 
				"          vertical-align: middle; \r\n" + 
				"		  padding-top: .8em;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"img {\r\n" + 
				"        border: none;\r\n" + 
				"        -ms-interpolation-mode: bicubic\r\n" + 
				"}\r\n" + 
				"div[style*=\"margin: 16px 0\"] { \r\n" + 
				"    margin:0 !important;\r\n" + 
				"}\r\n" + 
				".wrapper {\r\n" + 
				"     display: block;\r\n" + 
				"        margin: 0 auto !important;\r\n" + 
				"        max-width: 580px;\r\n" + 
				"        padding: 10px;\r\n" + 
				"        width: 580px;\r\n" + 
				"}\r\n" + 
				".webkit {\r\n" + 
				"   box-sizing: border-box;\r\n" + 
				"        display: block;\r\n" + 
				"        margin: 0 auto;\r\n" + 
				"        max-width: 580px;\r\n" + 
				"        padding: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".outer {\r\n" + 
				" background: #ffffff;\r\n" + 
				"        border-radius: 5px;\r\n" + 
				"        width: 600px; \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".viewheader {\r\n" + 
				"		clear: both;\r\n" + 
				"	    margin-top: 10px;\r\n" + 
				"	    text-align: center;\r\n" + 
				"	    width: 100%;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				".content-block {\r\n" + 
				"	padding-bottom: 10px;\r\n" + 
				"	padding-top: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".viewfooter {\r\n" + 
				"	clear: both;\r\n" + 
				"	margin-top: 10px;\r\n" + 
				"	text-align: center;\r\n" + 
				"	width: 100%; \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".footer td, \r\n" + 
				".footer p, \r\n" + 
				".footer span, \r\n" + 
				".footer a {\r\n" + 
				"	color: #999999;\r\n" + 
				"	font-size: 12px;\r\n" + 
				"	text-align: center; \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".powered-by a {\r\n" + 
				"    text-decoration: none; \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				".twelve-column{\r\n" + 
				"text-align: center;\r\n" + 
				"    font-size: 0;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-1,.twelve-column .md-1,.twelve-column .lg-1{\r\n" + 
				"width:8.33%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-2,.twelve-column .md-2,.twelve-column .lg-2{\r\n" + 
				"width:16.66%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-3,.twelve-column .md-3,.twelve-column .lg-3{\r\n" + 
				"width:25%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-4,.twelve-column .md-5,.twelve-column .lg-6{\r\n" + 
				"width:33.33%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-5,.twelve-column .md-5,.twelve-column .lg-5{\r\n" + 
				"width:41.66%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-6,.twelve-column .md-6,.twelve-column .lg-6{\r\n" + 
				"width:50%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-7,.twelve-column .md-7,.twelve-column .lg-7{\r\n" + 
				"width:58.33%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-8,.twelve-column .md-8,.twelve-column .lg-8{\r\n" + 
				"width:25%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-9,.twelve-column .md-9,.twelve-column .lg-9{\r\n" + 
				"width:75%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-10,.twelve-column .md-10,.twelve-column .lg-10{\r\n" + 
				"width:83.33%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-11,.twelve-column .md-11,.twelve-column .lg-11{\r\n" + 
				"width:91.66%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-12,.twelve-column .md-12,.twelve-column .lg-12{\r\n" + 
				"width:100%;\r\n" + 
				"}\r\n" + 
				".twelve-column .xs-6 .column, .twelve-column .md-6 .column  .twelve-column .lg-6 .column {\r\n" + 
				"	width: 100%;\r\n" + 
				"    max-width: 300px;\r\n" + 
				"    display: inline-block;\r\n" + 
				"    vertical-align: top;\r\n" + 
				"}\r\n" + 
				".inner{\r\n" + 
				"font-size: 20px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".twelve-column .contents {\r\n" + 
				"font-size: 14px;\r\n" + 
				"    text-align: left;\r\n" + 
				"	width: 100%;\r\n" + 
				"overflow: hidden; \r\n" + 
				" overflow-wrap: break-word;\r\n" + 
				"}\r\n" + 
				".twelve-column img {\r\n" + 
				"    width: 100%;\r\n" + 
				"    max-width: 80px;\r\n" + 
				"    height: auto;\r\n" + 
				"}\r\n" + 
				".twelve-column .text {\r\n" + 
				"    padding-top: 10px;\r\n" + 
				"}\r\n" + 
				".col-1{\r\n" + 
				"width: 8.33%;\r\n" + 
				"max-width:50px; \r\n" +
				 "}\r\n" + 
				".summaryContainer {\r\n" + 
				"	border: 1px solid black;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".summaryContainer .container-title {\r\n" + 
				"	font-weight: bold\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".amountDueContainer {\r\n" + 
				"	border: 1px solid black;\r\n" + 
				"	background-color: #9dcfe6\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".amountDueContainer div {\r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"caption {\r\n" + 
				"	text-align: left;\r\n" + 
				"	padding: 5px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".underlined-caption caption {\r\n" + 
				"	border-bottom: 1px solid black;\r\n" + 
				"}");
		writer.append("</style>\n</head>\n");
		writer.append("<body>\r\n  				<center class=\"wrapper\">\r\n");
//		log.info("within container --> dm lg "+modelMain.getPageName());

		writer.append("<div class=\"webkit\">\r\n" + 
				"<!--[if (gte mso 9)|(IE)]>\r\n" + 
				"<table class=\"outer\" align=\"center\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" ); 
		writer.append("<table class=\"outer\">\r\n" + 
				"			<tr>\r\n" + 
				"			 <td class=\"twelve-column\">\r\n");
		
		//writer.append("Sushil Kumar Singh");
		if(childChecker.checkChild(domainModel.getChildren().size())) {
			
		for(DomainModel dm:domainModel.getChildren()) {
			
		   ComponentInterface component = (ComponentInterface) context.getBean(dm.getType());
		   component.getGeneratedView(writer,dm);
		   
		}//for loop
		
		}//if child checker
		writer.append("</td>\r\n" + 
				"        </tr>\r\n" + 
				"     </table>\r\n");
		writer.append("<!--[if (gte mso 9)|(IE)]>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"<![endif]-->\r\n");
		writer.append("</div>\r\n");
		writer.append("</center>\r\n");
		writer.append("</body>\r\n");
		writer.append("</html>");
		 
		System.err.println(writer.toString());
		 
	   return writer;
	}

}
