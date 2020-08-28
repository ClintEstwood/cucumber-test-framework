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
    @Given("I get latest foreign exchange rates with symbols {string} via REST API and save it into variable {string}")
    public void iGetLatestForeignRatesForExchangeSStringViaRESTAPIAndSaveItIntoVariableString(String exchanges, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRatesWithSymbols(exchanges));
    }

    @Given("I get latest foreign exchange rates with base {string} via REST API and save it into variable {string}")
    public void iGetLatestForeignExchangeRatesWithBaseViaRESTAPIAndSaveItIntoVariable(String base, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRatesWithBase(base));
    }

    @Given("I get latest foreign exchange rates with symbols {string} and base {string} via REST API and save it into variable {string}")
    public void iGetLatestForeignExchangeRatesForExchangesAndBaseViaRESTAPIAndSaveItIntoVariable(String symbols, String base, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRatesWithSymbolsAndBase(symbols, base));
    }
}
