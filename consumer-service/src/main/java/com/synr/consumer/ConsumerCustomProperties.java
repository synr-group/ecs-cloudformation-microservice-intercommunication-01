package com.synr.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "consumer")
public class ConsumerCustomProperties {

	private String producerServiceUrl;

	/**
	 * @return the producerServiceUrl
	 */
	public String getProducerServiceUrl() {
		return producerServiceUrl;
	}

	/**
	 * @param producerServiceUrl the producerServiceUrl to set
	 */
	public void setProducerServiceUrl(String producerServiceUrl) {
		this.producerServiceUrl = producerServiceUrl;
	}

}
