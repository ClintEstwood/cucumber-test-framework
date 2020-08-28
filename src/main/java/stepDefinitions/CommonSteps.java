package stepDefinitions;

import core.ScenarioContext;
import core.models.Exchange;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CommonSteps {

    private ScenarioContext scenarioContext;

    public CommonSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("Verify that variables {string} and {string} are the same")
    public void iGetLatestForeignExchangeRatesViaRESTAPI(String variable1, String variable2) {
        Assertions.assertThat(scenarioContext.getContext(variable1)).isEqualToComparingOnlyGivenFields(scenarioContext.getContext(variable2));
    }

    @Then("Verify that exchange rates in variable {string} has base {string}")
    public void verifyThatExchangeRatesInVariableHasBase(String variableName, String expectedBase) {
        Exchange exchange = (Exchange) scenarioContext.getContext(variableName);
        Assertions.assertThat(exchange.getBase()).isEqualTo(expectedBase);
    }

    @Then("Verify that exchange rates in variable {string} has symbols {string}")
    public void verifyThatExchangeRatesInVariableHasSymbols(String variableName, String expectedSymbols) {
        Exchange exchange = (Exchange) scenarioContext.getContext(variableName);
        List<String> actualSymbols = new ArrayList<>();
        exchange.getRates().forEach(rate -> actualSymbols.add(rate.getExchange()));
        Assertions.assertThat(actualSymbols).contains(StringUtils.split(expectedSymbols, ","));
    }
}
