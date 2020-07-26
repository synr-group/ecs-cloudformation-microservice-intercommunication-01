package com.synr.producer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController implements HelloApi {

	private static final Logger log = LoggerFactory.getLogger(HelloApiController.class);

	@Override
	public String getHelloMessage(String userName) {
		log.info(">>> UserName: {}", userName);
		return "Hello " + userName;
	}

}
