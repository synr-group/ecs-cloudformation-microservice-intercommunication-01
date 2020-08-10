package com.synr.producer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Configuration
public class JacksonConfig {

	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		return new Jackson2ObjectMapperBuilder().indentOutput(true).serializationInclusion(JsonInclude.Include.NON_NULL)
				.propertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
	}
}
