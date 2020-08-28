package stepDefinitions;

import core.ScenarioContext;
import core.rest.GetRestData;
import io.cucumber.java.en.Given;

public class RestSteps {

    private ScenarioContext scenarioContext;

    public RestSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("I get latest foreign exchange rates via REST API and save it into variable {string}")
    public void iGetLatestForeignExchangeRatesViaRESTAPI(String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRates());
    }

    //exchanges example: "USD,GBP,PLN"
    @Given("I get latest foreign rates for exchange(s) {string} via REST API and save it into variable {string}")
    public void iGetLatestForeignRatesForExchangeSStringViaRESTAPIAndSaveItIntoVariableString(String exchanges, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRatesWithSymbols(exchanges));

    }
}
