package globalElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sidebar {

    @FindBy(css = "nav[id='ecb-sectionNav")
    private static WebElement navigationBar;

    public static WebElement getNavigationBar(){
        return navigationBar;
    }
}
