package core.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

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
@RunWith(Cucumber.class)
public class RunCucumberTest {
}
