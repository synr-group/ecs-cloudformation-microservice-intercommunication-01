package com.synr.user.mgmt.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Producer service", description = "Producer service API")
@RequestMapping(value = "/api")
public interface HelloApi {

	@ApiOperation(value = "Get Hello", nickname = "getHelloMessage", notes = "", response = String.class, tags = {
			"Hello", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 406, message = "Not Acceptable"),
			@ApiResponse(code = 415, message = "Unsupported Media Type"),
			@ApiResponse(code = 429, message = "Too Many Requests"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	@RequestMapping(method = RequestMethod.GET, value = "/hello/{userName}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	String getHelloMessage(@PathVariable("userName") String userName);
}
