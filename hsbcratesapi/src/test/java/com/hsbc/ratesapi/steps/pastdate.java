package com.hsbc.ratesapi.steps;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hsbc.ratesapi.restassured.RestAPIHelper;
import com.hsbc.ratesapi.utils.ServiceFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class pastdate extends ServiceFactory{

		@Given("^Rates API for foreign exchange rates$")
		public void rates_API_for_foreign_exchange_rates() throws Throwable {
			
			
		   
		}

		@Given("^Rates API for foreign exchange rates a request contains date equal to \"(.*?)\"$")
		public void rates_API_for_foreign_exchange_rates_a_request_contains_date_equal_to(String Date) throws Throwable {
			
			RestAPIHelper.performGetRequest(config.getProperty("past_conversion_date")+Date);	

			System.out.println(responseRepository.getResponseObject().getResponseBody());
		    
			
		}

		@Then("^the service response is \"(.*?)\"$")
		public void the_service_response_is(String arg1) throws Throwable {
			
			
		  
		}

		@Then("^the \"(.*?)\" returned is \"(.*?)\"$")
		public void the_returned_is(String arg1, String arg2) throws Throwable {
		   
	}

}
