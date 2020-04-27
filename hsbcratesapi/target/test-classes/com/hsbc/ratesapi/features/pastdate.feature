Feature:  
	Rates API is a free service for current and historical foreign exchange rates built on top of data published by Europian Central Bank

Scenario Outline: To test Rates API with passing latest date as input parameter and validate full success response.
 Given Rates API for foreign exchange rates a request contains date equal to "<date>"
 And the base returned is "<base>"
 And the "rates_GBP" returned is "<rates_GBP>"
 And the "rates_HKD" returned is "<rates_HKD>"
 And the "response_date" returned is "<response_date>"
 
 Examples:
  | date       | base | rates_GBP | rates_HKD | response_date |
  | 2020-04-25 | EUR  | 0.87498   | 8.3706    | 2020-04-25    |