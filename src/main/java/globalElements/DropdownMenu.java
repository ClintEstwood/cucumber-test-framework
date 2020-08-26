package globalElements;

import org.openqa.selenium.By;

public class DropdownMenu {

    private static By linkList = By.cssSelector("[class='ecb-linkListContainer'] a");

    public static By getLinkList(){
        return linkList;
    }

}
