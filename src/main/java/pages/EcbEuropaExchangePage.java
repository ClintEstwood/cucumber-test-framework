package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EcbEuropaExchangePage {

    @FindBy(css = "div[class='forextable']")
    public WebElement exchangeTable;

    @FindBy(css = "tbody tr")
    public WebElement exchangeTableRow;

    @FindBy(css = "td[class='currency']")
    public WebElement exchangeTableCurrencyCell;

    @FindBy(css = "td[class='spot number'] span[class='rate']")
    public WebElement exchangeTableRateCell;

}
