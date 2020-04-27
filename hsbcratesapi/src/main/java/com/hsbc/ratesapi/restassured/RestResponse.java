package com.hsbc.ratesapi.restassured;

import java.io.Serializable;

public class RestResponse implements Serializable{

	private int statusCode;

	private String responseBody;

	public RestResponse(int statusCode, String responseBody) {

		this.statusCode = statusCode;

		this.responseBody = responseBody;

	}

	public int getStatusCode() {

		return statusCode;

	}

	public void setStatusCode(int statusCode) {

		this.statusCode = statusCode;

	}

	public String getResponseBody() {

		return responseBody;
	}

	public void setResponseBody(String responseBody) {

		this.responseBody = responseBody;

	}

	@Override
	public String toString() {

		return String.format("Status Code - %ls Response Body : %2s", this.statusCode, this.responseBody);

	}

}
