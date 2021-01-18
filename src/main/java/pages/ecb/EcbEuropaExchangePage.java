package pages.ecb;

import core.pages.PageActions;
import org.openqa.selenium.By;

public class EcbEuropaExchangePage implements PageActions {

    private static final By exchangeTable = By.cssSelector("div[class='forextable']");
    private static final By exchangeTableRow = By.cssSelector("tbody tr");
    private static final By exchangeTableCurrencyCell = By.cssSelector("td[class='currency']");
    private static final By exchangeTableRateCell = By.cssSelector("td[class='spot number'] span[class='rate']");
    private static final By exchangeDate = By.xpath("//h2[contains(text(),'Euro foreign exchange reference rates: ')]");

    @Override
    public By getSelectorByName(String elementName) {
        return switch (elementName.toUpperCase()) {
            case "EXCHANGE TABLE" -> exchangeTable;
            case "EXCHANGE TABLE ROW" -> exchangeTableRow;
            case "EXCHANGE TABLE CURRENCY CELL" -> exchangeTableCurrencyCell;
            case "EXCHANGE TABLE RATE CELL" -> exchangeTableRateCell;
            case "EXCHANGE DATE" -> exchangeDate;
            default -> throw new IllegalStateException("Can't find element with name: " + elementName +
                    " on page 'Euro foreign exchange reference rates'");
        };
    }



}
