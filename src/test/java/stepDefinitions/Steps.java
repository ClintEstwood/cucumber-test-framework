package stepDefinitions;

import core.hooks.ChromeHooks;
import io.cucumber.java.en.Given;

public class Steps {
    @Given("I run Chrome browser")
    public void i_run_chrome_browser(){
        ChromeHooks.driver.get("https://www.Google.com");
    }

}
