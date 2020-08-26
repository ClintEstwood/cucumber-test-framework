package globalElements;

import org.openqa.selenium.By;

public class Sidebar {

    private static final By navigationBar = By.cssSelector("nav[id='ecb-sectionNav]");

    public static By getNavigationBar(){
        return navigationBar;
    }
}
