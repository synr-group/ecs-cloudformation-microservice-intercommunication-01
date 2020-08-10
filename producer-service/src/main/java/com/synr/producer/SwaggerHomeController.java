package com.synr.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class SwaggerHomeController {

	private static final Logger log = LoggerFactory.getLogger(SwaggerHomeController.class);

	@RequestMapping(value = "/")
	public String index() {
		log.info("swagger-ui.html");
		return "redirect:swagger-ui.html";
	}
}