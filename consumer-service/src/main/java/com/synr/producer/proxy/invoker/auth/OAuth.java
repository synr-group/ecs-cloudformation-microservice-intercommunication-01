package com.synr.producer.proxy.invoker.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-26T02:59:48.675+02:00")
public class OAuth implements Authentication {
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public void applyToParams(MultiValueMap<String, String> queryParams, HttpHeaders headerParams) {
		if (accessToken != null) {
			headerParams.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		}
	}
}
