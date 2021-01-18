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
import pages.ecb.EcbEuropaExchangePage;
import pages.ecb.EuropeanCentralBankMainPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UiSteps {
    private static final String EURO_REFERENCE_EXCHANGE_RATES_URL = "https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/index.en.html";
    private ScenarioContext scenarioContext;
    private EcbEuropaExchangePage ecbEuropaExchangePage = new EcbEuropaExchangePage();
    private EuropeanCentralBankMainPage europeanCentralBankMainPage = new EuropeanCentralBankMainPage();

    public UiSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        Selenide.open(url);
        $(By.partialLinkText("I understand and I accept the use of cookies"))
                .waitUntil(Condition.appears, 2000).click();
    }

    @Then("I get latest foreign exchange rates from the ECB page and save it into variable {string}")
    public void iGetLatestForeignExchangeRatesFromTheECBPage(String variableName) {
        scenarioContext.setContext(variableName, getLatestForeignExchangeRatesFromTheECBPage());
    }

    private List<Rate> getListOfRatesFromTheECBPage() {
        List<Rate> rateList = new ArrayList<>();
        $(ecbEuropaExchangePage.getSelectorByName("EXCHANGE TABLE"))
                .findAll(ecbEuropaExchangePage.getSelectorByName("EXCHANGE TABLE ROW")).forEach(row -> {
            String currency = $(row).find(ecbEuropaExchangePage.getSelectorByName("EXCHANGE TABLE CURRENCY CELL")).getText();
            Float rateString = Float.parseFloat($(row).find(ecbEuropaExchangePage
                    .getSelectorByName("EXCHANGE TABLE RATE CELL")).getText());
            rateList.add(new Rate(currency, rateString));
        });
        return rateList;
    }

    private Exchange getLatestForeignExchangeRatesFromTheECBPage() {
        List<Rate> rateList = getListOfRatesFromTheECBPage();
        LocalDate exchangeDate = LocalDate.parse(StringUtils.remove($(ecbEuropaExchangePage
                .getSelectorByName("EXCHANGE DATE"))
                .getText(), "Euro foreign exchange reference rates: "), DateTimeFormatter.ofPattern("dd MMMM yyyy"));

        return new Exchange("EUR", rateList, exchangeDate);
    }

    @When("I click on {string} element/link/dropdown on European Central Bank Main page")
    public void iClickOnElementOnEuropeanCentralBankMainPage(String elementName) {
        $(europeanCentralBankMainPage.getSelectorByName(elementName)).click();
    }

    @And("I click on link {string}")
    public void iNavigateToViaSidebar(String linkText) {
        $(By.partialLinkText(linkText)).waitUntil(Condition.appears, 2000).click();
    }

    @And("I click on {string} link on dropdown menu")
    public void iClickOnLinkOnDropdownMenu(String linkLabel) {
        $$(DropdownMenu.getLinkList()).findBy(Condition.text(linkLabel)).click();
    }

    @When("I go to the Euro foreign exchange reference rates page")
    public void iGoToTheEuroForeignExchangeReferenceRatesPage() {
        iGoToThePage(EURO_REFERENCE_EXCHANGE_RATES_URL);
    }

    @And("I get latest foreign rates for exchanges {string} from the ECB page and save it into variable {string}")
    public void iGetLatestForeignRatesForExchangesFromTheECBPageAndSaveItIntoVariable(String exchanges, String variableName) {
        Exchange exchangeUi = getLatestForeignExchangeRatesFromTheECBPage();
        List<Rate> filteredRates = exchangeUi.getRates().stream()
                .filter(r -> Arrays.asList(StringUtils.split(exchanges, ",")).contains(r.getExchange()))
                .collect(Collectors.toList());

        scenarioContext.setContext(variableName, new Exchange(exchangeUi.getBase(), filteredRates, exchangeUi.getDate()));
    }
}
