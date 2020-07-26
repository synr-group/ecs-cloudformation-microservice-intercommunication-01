package com.synr.consumer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.synr.consumer.service.HelloService;

@RestController
public class HelloApiController implements HelloApiGateway {

	private static final Logger log = LoggerFactory.getLogger(HelloApiController.class);

	private HelloService helloService;

	public HelloApiController(HelloService helloService) {
		super();
		this.helloService = helloService;
	}

	@Override
	public String getHelloMessage(String userName) {
		log.info(">>> UserName: {}", userName);
		return helloService.getHelloMessage(userName);
	}

}
