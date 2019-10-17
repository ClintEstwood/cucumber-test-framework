package core.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ChromeHooks {

    @Before
    public void beforeScenario(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
    }
}
