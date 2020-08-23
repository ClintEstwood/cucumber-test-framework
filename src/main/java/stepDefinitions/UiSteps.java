package stepDefinitions;

import com.codeborne.selenide.Selenide;
import core.models.Exchange;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UiSteps {

    Exchange exchangeUi;

    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        Selenide.open(url);
    }

    @Then("I get latest foreign exchange rates from the ECB page")
    public void iGetLatestForeignExchangeRatesFromTheECBPage() {
        exchangeUi = getLatestForeignExchangeRatesFromTheECBPage();
    }

    private Exchange getLatestForeignExchangeRatesFromTheECBPage() {
    //todo: right something
        return null;
    }

    @When("I click on {string} element/link on {string} page")
    public void iClickOnElement(String elementName, String pageLabel) {

    }
}
