package com.paxcel.mail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
	
	private static Logger log = LoggerFactory.getLogger(RestJsonController.class);
	
	@GetMapping("/test")
    public String emailTemplateEbillDesign( Model model) {
		log.info("In the test template play controller");
        return "/test";
    }

}
