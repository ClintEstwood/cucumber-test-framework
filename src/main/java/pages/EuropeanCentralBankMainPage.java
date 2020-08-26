package pages;

import core.pages.PageActions;
import org.openqa.selenium.By;

public class EuropeanCentralBankMainPage implements PageActions {

    private final By linkStatistics = By.cssSelector("[id='navstats']");

    @Override
    public By getSelectorByName(String elementName) {
        return switch (elementName.toUpperCase()) {
            case "STATISTICS" -> linkStatistics;
            default -> throw new IllegalStateException("Can't find element with name: " + elementName +
                    " on page 'European central bank main page'");
        };
    }
}
