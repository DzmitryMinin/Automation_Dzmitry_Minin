package homework18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunRabotaTests {
    @CucumberOptions(features = {"src/test/resources/features/rabotaby.feature"},
            plugin = {"json:target/cucumber.json"},
            glue = {"cucumber/rabotaby"})

    public class RabotaRunTests extends AbstractTestNGCucumberTests {

    }
}
