package com.paxcel.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paxcel.mail.common.ChildChecker;
import com.paxcel.mail.model.DomainModel;
import com.paxcel.mail.model.ModelMain;

@Service
public class HtmlGenerateServiceImpl /* implements HtmlGenerateServiceInterface */ {

	private static Logger log=LoggerFactory.getLogger(HtmlGenerateServiceImpl.class);
	
	
	@Autowired
	private ChildChecker childChecker;
	
	private static StringBuilder  strBuilder1 = new StringBuilder ();
	
	//@Override
	public StringBuilder createHtmlTags(ModelMain modelMain) {
		//strBuilder.delete(0, strBuilder.capacity());
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		strBuilder.append("<html>\n");
		strBuilder.append("<head><style type=\"text/css\">\n");
		strBuilder.append("body {\r\n" + 
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
				"}'\r\n" + 
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
				"max-width:50px;\r\n" + 
				"}");
		strBuilder.append("</style>\n</head>\n");
		strBuilder.append("<body>\r\n  				<center class=\"wrapper\">\r\n");
		log.info("within container --> dm lg "+modelMain.getPageName());
//Main Start
		strBuilder.append("<div class=\"webkit\">\r\n" + 
				"<!--[if (gte mso 9)|(IE)]>\r\n" + 
				"<table class=\"outer\" align=\"center\">\r\n" + 
				"<tr>\r\n" + 
				"<td>\r\n" + 
				"<![endif]-->\r\n" ); 
		strBuilder.append("<table class=\"outer\">\r\n" + 
				"			<tr>\r\n" + 
				"			 <td class=\"twelve-column\">\r\n");
		
//---->Recursion Start			
				System.err.println(modelMain.getDomainModel().getType());
				for(DomainModel dm : modelMain.getDomainModel().getChildren()) {
					strBuilder.append("<table class=\"md-"+dm.getMd().get("md")+"\">\r\n");
					
					//System.err.println("Container Type "+dm.getType());
					//strBuilder.append(""+dm.getType()+"\r\n");
					    StringBuilder str = tableLayout(dm);
//						StringBuilder str = tableLayoutNew(dm);
					    if(str!= null)strBuilder.append(str);
					    strBuilder1.delete(0, strBuilder1.capacity());
					strBuilder.append("</table>\r\n");
				}
//---->Recursion Stop  		
		strBuilder.append("</td>\r\n" + 
				"        </tr>\r\n" + 
				"     </table>\r\n");
		strBuilder.append("<!--[if (gte mso 9)|(IE)]>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"<![endif]-->\r\n");
		strBuilder.append("</div>\r\n");
		strBuilder.append("</center>\r\n");
		strBuilder.append("</body>\r\n");
		strBuilder.append("</html>");
		
		System.out.println(strBuilder.toString());
		return strBuilder;  // strBuilder.toString()
	}
	
public StringBuilder tableLayout(DomainModel domainModel) {
		
		if(childChecker.checkChild(domainModel.getChildren().size())) {
		
		for(DomainModel domainModelNew:domainModel.getChildren()) {
			if("Container".equals(domainModelNew.getType())) {
				strBuilder1.append("<div class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n");
				  if(childChecker.checkChild(domainModelNew.getChildren().size())) {
					  for(DomainModel dm:domainModelNew.getChildren()) {
						       tableLayout(dm);
					  }
					  break;
				  }
//				strBuilder1.append("</div>\r\n");
			}
			if("ViewCol".equals(domainModelNew.getType())) {
				strBuilder1.append("<div class=\""+domainModelNew.getMd().get("md")+"\">\r\n");
				  if(childChecker.checkChild(domainModelNew.getChildren().size())) {
					  for(DomainModel dm:domainModelNew.getChildren()) {
						       tableLayout(dm);
					  }
					  break;
				  }
//				strBuilder1.append("</div>\r\n");
			}
			if("Form".equals(domainModelNew.getType())) {
				strBuilder1.append("<div class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n");
				  if(childChecker.checkChild(domainModelNew.getChildren().size())) {
					  for(DomainModel dm:domainModelNew.getChildren()) {
						 tableLayout(dm);
					  }
					  break;
				  }
//				strBuilder1.append("</div>\r\n");
			}
			if("ContainerRow".equals(domainModelNew.getType())) {
				strBuilder1.append("<tr class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n"); //main tr start
				  if(childChecker.checkChild(domainModelNew.getChildren().size())) {
					  for(DomainModel dm:domainModelNew.getChildren()) {
						tableLayout(dm);
					  }
				  }
//				 strBuilder1.append("</tr>");				
			}else if("Image".equals(domainModelNew.getType())) {
				strBuilder1.append("<td class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n");
				strBuilder1.append("<table width=\"100%\">\r\n" + 
						"				<tr>\r\n");
				strBuilder1.append(" <td class=\"contents\">\r\n");
				strBuilder1.append("<img src=\""+domainModelNew.getSrc()+"\" alt=\""+domainModelNew.getAltText()+"\" width=\""+domainModelNew.getWidth()+"\"  />\r\n");
				
				strBuilder1.append(" </td>\r\n");
				strBuilder1.append("</tr>\r\n" + 
						"	   </table>\r\n");
				strBuilder1.append(" </td>\r\n");
				
//				strBuilder1.append("</tr>");//main tr close
			}else if("TextInput".equals(domainModelNew.getType())) {
				
				  strBuilder1.append("<td class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n");
				  strBuilder1.append("<table width=\"100%\">\r\n"
				  		+ "				<tr>\r\n"); 
				  strBuilder1.append(" <td>\r\n");
				  strBuilder1.append("<input type=\"text\" value=\""+domainModelNew.getBinding()+"\" />\r\n");
				  strBuilder1.append(" </td>\r\n");
				  strBuilder1.append("</tr>\r\n"
				  		 +"	  </table>\r\n");
				  strBuilder1.append(" </td>\r\n"); 
				 
//				  strBuilder1.append("</tr>");//main tr close
			}else if("PlainText".equals(domainModelNew.getType())) {
				strBuilder1.append("<td class=\"md-"+domainModelNew.getMd().get("md")+"\">\r\n");
				strBuilder1.append("<table  class=\"viewfooter footer\" style=\"align:center;\">\r\n		<tr>\r\n");
				strBuilder1.append(" <td class=\"twelve-column\">\r\n");				
				strBuilder1.append("<div>"+domainModelNew.getMessageKey()+"</div>\r\n");				
				strBuilder1.append(" </td>\r\n");
				strBuilder1.append("</tr>\r\n	   </table>\r\n");
				strBuilder1.append(" </td>\r\n");	
				
//				strBuilder1.append("</tr>");//main tr close
			}
				
			if(childChecker.checkChild(domainModelNew.getChildren().size())) {
				 tableLayout(domainModelNew); 
			}//inner loop if
		 }//for loop
		}//if check 
		else {
			
		}
		return strBuilder1;
	}

	
}
