package com.synr.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.synr.consumer.ConsumerCustomProperties;
import com.synr.producer.proxy.api.HelloApi;
import com.synr.producer.proxy.invoker.ApiClient;

@Component
public class HelloService {

	private ConsumerCustomProperties consumerCustomProperties;

	public HelloService(ConsumerCustomProperties consumerCustomProperties) {
		super();
		this.consumerCustomProperties = consumerCustomProperties;
	}

	private static final Logger log = LoggerFactory.getLogger(HelloService.class);

	public String getHelloMessage(String userName) {
		log.info(">>> UserName: {}", userName);

		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(consumerCustomProperties.getProducerServiceUrl());
		log.info(">>> producer service base url: {}", consumerCustomProperties.getProducerServiceUrl());

		HelloApi helloApi = new HelloApi(apiClient);
		return helloApi.getHelloMessage(userName);
	}

}
