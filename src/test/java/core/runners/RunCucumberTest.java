package core.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}