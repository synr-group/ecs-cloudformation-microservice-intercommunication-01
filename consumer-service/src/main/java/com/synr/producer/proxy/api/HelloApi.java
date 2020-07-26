package com.synr.producer.proxy.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import com.synr.producer.proxy.invoker.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-26T02:59:48.675+02:00")
@Component("com.synr.producer.proxy.api.HelloApi")
public class HelloApi {
	private ApiClient apiClient;

	public HelloApi() {
		this(new ApiClient());
	}

	@Autowired
	public HelloApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Get Hello
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>400</b> - Bad Request
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * <p>
	 * <b>404</b> - Not Found
	 * <p>
	 * <b>406</b> - Not Acceptable
	 * <p>
	 * <b>415</b> - Unsupported Media Type
	 * <p>
	 * <b>429</b> - Too Many Requests
	 * <p>
	 * <b>500</b> - Internal Server Error
	 * 
	 * @param userName userName (required)
	 * @return String
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public String getHelloMessage(String userName) throws RestClientException {
		return getHelloMessageWithHttpInfo(userName).getBody();
	}

	/**
	 * Get Hello
	 * 
	 * <p>
	 * <b>200</b> - OK
	 * <p>
	 * <b>400</b> - Bad Request
	 * <p>
	 * <b>401</b> - Unauthorized
	 * <p>
	 * <b>403</b> - Forbidden
	 * <p>
	 * <b>404</b> - Not Found
	 * <p>
	 * <b>406</b> - Not Acceptable
	 * <p>
	 * <b>415</b> - Unsupported Media Type
	 * <p>
	 * <b>429</b> - Too Many Requests
	 * <p>
	 * <b>500</b> - Internal Server Error
	 * 
	 * @param userName userName (required)
	 * @return ResponseEntity&lt;String&gt;
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public ResponseEntity<String> getHelloMessageWithHttpInfo(String userName) throws RestClientException {
		Object postBody = null;

		// verify the required parameter 'userName' is set
		if (userName == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'userName' when calling getHelloMessage");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("userName", userName);
		String path = UriComponentsBuilder.fromPath("/api/hello/{userName}").buildAndExpand(uriVariables).toUriString();

		final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders headerParams = new HttpHeaders();
		final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

		final String[] accepts = { "application/json" };
		final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
		final String[] contentTypes = {};
		final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
		};
		return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept,
				contentType, authNames, returnType);
	}
}
