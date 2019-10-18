package core.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty"
        },
        features = {
                "src/test/resources/features"
        },
        glue = {
                "stepDefinitions",
                "core.hooks"
        }
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
