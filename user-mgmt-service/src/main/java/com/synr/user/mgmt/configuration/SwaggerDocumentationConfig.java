package com.synr.user.mgmt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocumentationConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Producer service example specification v1.0")
				.description("Producer service standard version 1.0").license("").licenseUrl("http://unlicense.org")
				.termsOfServiceUrl("").version("1.0").contact(new Contact("", "", "")).build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.synr.producer.api"))
				// .paths(PathSelectors.ant("/actuator/**"))
				.build().apiInfo(apiInfo());
	}
}
