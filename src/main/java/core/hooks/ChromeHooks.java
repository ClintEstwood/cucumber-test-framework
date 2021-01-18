package core.hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.logging.Level;

public class ChromeHooks {

    private String CHROME_BINARY_PATH = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
    private String CHROME_DRIVER_PATH = "src/test/resources/webdrivers/chromedriver_87.exe";

    @Before
    public void beforeScenario(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(CHROME_BINARY_PATH);
        chromeOptions.addArguments("start-maximized");

        WebDriverRunner.setWebDriver(new ChromeDriver(chromeOptions));
    }

    @After
    public void afterScenario(){
        WebDriverRunner.driver().close();
    }
}
