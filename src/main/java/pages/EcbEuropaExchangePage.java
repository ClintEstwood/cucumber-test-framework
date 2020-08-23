package pages;

import core.pages.PageActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EcbEuropaExchangePage implements PageActions {

    @Override
    public WebElement getElementByName(String elementName) {
        return switch (elementName.toUpperCase()) {
            case "EXCHANGE TABLE" -> exchangeTable;
            case "EXCHANGE TABLE ROW" -> exchangeTableRow;
            case "EXCHANGE TABLE CURRENCY CELL" -> exchangeTableCurrencyCell;
            case "EXCHANGE TABLE RATE CELL" -> exchangeTableRateCell;
            default -> throw new IllegalStateException("Can't find element with name: " + elementName +
                    " on page 'Euro foreign exchange reference rates'");
        };
    }

    @FindBy(css = "div[class='forextable']")
    private static WebElement exchangeTable;

    @FindBy(css = "tbody tr")
    private static WebElement exchangeTableRow;

    @FindBy(css = "td[class='currency']")
    private static WebElement exchangeTableCurrencyCell;

    @FindBy(css = "td[class='spot number'] span[class='rate']")
    private static WebElement exchangeTableRateCell;

}
