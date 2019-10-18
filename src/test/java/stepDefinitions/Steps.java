package stepDefinitions;

import core.hooks.ChromeHooks;
import io.cucumber.java.en.Given;

public class Steps {
    @Given("I go to the (.*?) page")
    public void i_run_chrome_browser(String url){
        ChromeHooks.driver.get("https://" + url);
    }
}
