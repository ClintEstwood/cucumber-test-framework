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
    @Given("I get latest foreign exchange rates with symbol(s) {string} via REST API and save it into variable {string}")
    public void iGetLatestForeignRatesForExchangeSStringViaRESTAPIAndSaveItIntoVariableString(String exchanges, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRatesWithSymbols(exchanges));
    }

    @Given("I get latest foreign exchange rates with base {string} via REST API and save it into variable {string}")
    public void iGetLatestForeignExchangeRatesWithBaseViaRESTAPIAndSaveItIntoVariable(String base, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRatesWithBase(base));
    }

    @Given("I get latest foreign exchange rates with symbol(s) {string} and base {string} via REST API and save it into variable {string}")
    public void iGetLatestForeignExchangeRatesForExchangesAndBaseViaRESTAPIAndSaveItIntoVariable(String symbols, String base, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getLatestForeignExchangeRatesWithSymbolsAndBase(symbols, base));
    }

    @Given("I get foreign exchange rates with specific date {string} via REST API and save it into variable {string}")
    public void iGetForeignExchangeRatesWithSpecificDateViaRESTAPIAndSaveItIntoVariable(String date, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getSpecificDateForeignExchangeRates(date));

    }

    @Given("I get foreign exchange rates with specific date {string} and symbol(s) {string} via REST API and save it into variable {string}")
    public void iGetForeignExchangeRatesWithSpecificDateAndSymbolsViaRESTAPIAndSaveItIntoVariable(String date, String symbols, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getSpecificDateForeignExchangeRatesWithSymbols(date, symbols));
    }

    @Given("I get foreign exchange rates with specific date {string} and base {string} via REST API and save it into variable {string}")
    public void iGetForeignExchangeRatesWithSpecificDateAndAseViaRESTAPIAndSaveItIntoVariable(String date, String base, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getSpecificDateForeignExchangeRatesWithBase(date, base));
    }

    @Given("I get foreign exchange rates with specific date {string}, base {string} and symbol(s) {string} via REST API and save it into variable {string}")
    public void iGetForeignExchangeRatesWithSpecificDateBaseAndSymbolsViaRESTAPIAndSaveItIntoVariable(String date, String base, String symbols, String variableName) {
        scenarioContext.setContext(variableName, GetRestData.getSpecificDateForeignExchangeRatesWithSymbolsAndBase(date, symbols, base));
    }
}
