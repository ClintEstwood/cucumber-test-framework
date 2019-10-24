package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement buyNow;

}
