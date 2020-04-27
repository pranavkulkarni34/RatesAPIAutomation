Feature:  
	Rates API is a free service for current and historical foreign exchange rates built on top of data published by Europian Central Bank 

Scenario Outline:
To validate the status of Rates API for Latest Foreign Exchange rates
	Given Rates API for Latest Foreign Exchange rates "<TestCaseName>" 
	When The API is available "<APIEndPoint>" 
	Then User need to validate the status code <StatusCode> 
	Examples: 
		|TestCaseName|APIEndPoint|StatusCode|
		|To get latest date data|https://api.ratesapi.io/api/latest|200|
		|To get latest date data with symbols|https://api.ratesapi.io/api/latest?symbols=USD,GBP|200|
		|To get latest date data with base |https://api.ratesapi.io/api/latest?base=USD|200|
		|To get latest date data with symbol and base |https://api.ratesapi.io/api/latest?base=USD&symbols=GBP|200|
		
Scenario Outline:
To validate the status of Rates API for Specific date Foreign Exchange rates
	Given Rates API for Specific date Foreign Exchange rates "<TestCaseName>" 
	When The API is available "<APIEndPoint>" 
	Then User need to validate the status code <StatusCode> 
	Examples: 
		|TestCaseName|APIEndPoint|StatusCode|
		|To get Specific date Foreign Exchange rates data|ttps://api.ratesapi.io/api/2010-01-12|200|
		|To get lSpecific date Foreign Exchange rates data with symbols|https://api.ratesapi.io/api/2010-01-12?symbols=USD,GBP|200|
		|To get Specific date Foreign Exchange rates data with base |https://api.ratesapi.io/api/2010-01-12?base=USD|200|
		|To get lSpecific date Foreign Exchange rates with symbol and base |https://api.ratesapi.io/api/2010-01-12?base=USD&symbols=GBP|200|