package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features.feature"},
        glue = {"StepDefinitions"},
        plugin = {"pretty","json:target/JSONReports/reports.json","html:target/HTMLReports/reports.html","junit:target/JUnitReports/reports.xml"}
)
public class runner {
}
