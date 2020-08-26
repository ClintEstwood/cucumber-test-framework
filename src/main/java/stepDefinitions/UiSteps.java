package stepDefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.ScenarioContext;
import core.models.Exchange;
import core.models.Rate;
import globalElements.DropdownMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import pages.EcbEuropaExchangePage;
import pages.EuropeanCentralBankMainPage;
import pages.StatisticsPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UiSteps {

    Exchange exchangeUi;
    EcbEuropaExchangePage ecbEuropaExchangePage = new EcbEuropaExchangePage();
    EuropeanCentralBankMainPage europeanCentralBankMainPage = new EuropeanCentralBankMainPage();
    StatisticsPage statisticsPage = new StatisticsPage();

    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        Selenide.open(url);
        $(By.partialLinkText("I understand and I accept the use of cookies"))
                .waitUntil(Condition.appears, 2000).click();
    }

    @Then("I get latest foreign exchange rates from the ECB page")
    public void iGetLatestForeignExchangeRatesFromTheECBPage() {
        exchangeUi = getLatestForeignExchangeRatesFromTheECBPage();
    }

    private Exchange getLatestForeignExchangeRatesFromTheECBPage() {
        List<Rate> rateList = new ArrayList<>();
        $(ecbEuropaExchangePage.getSelectorByName("EXCHANGE TABLE"))
                .findAll(ecbEuropaExchangePage.getSelectorByName("EXCHANGE TABLE ROW")).forEach(row -> {
            String currency = $(row).find(ecbEuropaExchangePage.getSelectorByName("EXCHANGE TABLE CURRENCY CELL")).getText();
            Float rateString = Float.parseFloat($(row).find(ecbEuropaExchangePage
                    .getSelectorByName("EXCHANGE TABLE RATE CELL")).getText());
            rateList.add(new Rate(currency, rateString));
        });
        String exchangeDate = StringUtils.remove($(ecbEuropaExchangePage
                .getSelectorByName("EXCHANGE DATE"))
                .getText(), "Euro foreign exchange reference rates: ");

        return new Exchange("EUR", rateList, exchangeDate);
    }

    @When("I click on {string} element/link/dropdown on European Central Bank Main page")
    public void iClickOnElementOnEuropeanCentralBankMainPage(String elementName) {
        $(europeanCentralBankMainPage.getSelectorByName(elementName)).click();
    }

    @And("I click on {string} element/link on Statistics page")
    public void iClickOnElementOnStatisticsPage(String elementName) {
        $(statisticsPage.getSelectorByName(elementName)).click();
    }

    @And("I click on link {string}")
    public void iNavigateToViaSidebar(String linkText) {
        $(By.partialLinkText(linkText)).waitUntil(Condition.appears, 2000).click();
    }

    @And("I click on {string} link on dropdown menu")
    public void iClickOnLinkOnDropdownMenu(String linkLabel) {
        $$(DropdownMenu.getLinkList()).findBy(Condition.text(linkLabel)).click();
    }
}
