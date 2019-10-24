package stepDefinitions;

import core.hooks.ChromeHooks;
import io.cucumber.java.en.Given;

public class Steps {
    @Given("I go to the {string} page")
    public void i_go_to_the_page(String url){
        ChromeHooks.driver.get("https://" + url);
    }
}
