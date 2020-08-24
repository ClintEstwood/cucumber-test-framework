package globalElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownMenu {

    @FindBy(css = "[class='ecb-linkListContainer']")
    private static WebElement linkListContainer;

    public static WebElement getLinkListContainer(){
        return linkListContainer;
    }
}
