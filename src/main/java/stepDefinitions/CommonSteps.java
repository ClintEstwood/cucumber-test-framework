package stepDefinitions;

import core.ScenarioContext;
import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;

public class CommonSteps {

    private ScenarioContext scenarioContext;

    public CommonSteps(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    @Given("Verify that variables {string} and {string} are the same")
    public void iGetLatestForeignExchangeRatesViaRESTAPI(String variable1, String variable2) {
        Assertions.assertThat(scenarioContext.getContext(variable1)).isEqualToComparingOnlyGivenFields(scenarioContext.getContext(variable2));
    }
}
