package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Featurefiles/searchEmployee.feature",
        glue = {"StepDef"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report.html" },
        monochrome = true
)

public class TestRunner {
}
