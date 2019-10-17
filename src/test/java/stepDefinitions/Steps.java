package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    @Given("I run Chrome browser")
    public void i_run_chrome_browser(){
        WebDriver driver = new ChromeDriver();
        driver.get("www.Google.com");
    }

}
