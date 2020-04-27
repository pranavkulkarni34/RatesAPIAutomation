package com.hsbc.ratesapi.steps;

import org.junit.Assert;

import com.hsbc.ratesapi.restassured.RestAPIHelper;
import com.hsbc.ratesapi.utils.ServiceFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RatesAPI extends ServiceFactory {

	public RatesAPI() {

	}

	@Given("^Rates API for Latest Foreign Exchange rates \\\"(.*?)\\\"$")
	public void rates_API_for_Latest_Foreign_Exchange_rates(String testcaseName) {

	}

	@When("^The API is available \"(.*?)\"$")
	public void the_API_is_available(String endPoint) {

		RestAPIHelper.performGetRequest(endPoint);

	}

	@Then("^User need to validate the status code (\\d+)$")
	public void user_need_to_validate_the_status_code(int statusCode) {

		Assert.assertEquals(statusCode, responseRepository.getResponseObject().getStatusCode());

	}
	
	@Given("^Rates API for Specific date Foreign Exchange rates \"(.*?)\"$")
	public void rates_API_for_Specific_date_Foreign_Exchange_rates(String testcaseName)  {
	    
	}

}
