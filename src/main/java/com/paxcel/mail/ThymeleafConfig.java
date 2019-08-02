package com.paxcel.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

//@Configuration
@Component
public class ThymeleafConfig {
	
	@Autowired
	private SpringTemplateEngine templateEngine;

	@Bean
	public TemplateEngine emailTemplateEngine() {
		templateEngine = new SpringTemplateEngine();
	    templateEngine.addTemplateResolver(this.htmlTemplateResolver());
	    //templateEngine.addDialect(new SpringSecurityDialect());
	    //templateEngine.setTemplateEngineMessageSource(this.messageSource); //
	    return templateEngine;
	}

	private static ITemplateResolver htmlTemplateResolver() {
	    final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setOrder(Integer.valueOf(0));
	    templateResolver.setPrefix("/templates/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateResolver.DEFAULT_TEMPLATE_MODE);
	    templateResolver.setCharacterEncoding("UTF-8");
	    templateResolver.setCacheable(false);
	    return templateResolver;
	}

}
