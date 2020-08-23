package stepDefinitions;

import core.models.Exchange;
import core.rest.GetRestData;
import io.cucumber.java.en.Given;

public class RestSteps {

    Exchange exchangeRest;

    @Given("I get latest foreign exchange rates via REST API")
    public void iGetLatestForeignExchangeRatesViaRESTAPI() {
        exchangeRest = GetRestData.getLatestForeignExchangeRates();
    }
}
