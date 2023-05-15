package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumberReports.html",
        features = "src/test/resources/feature",
        glue="steps",
        tags="@positive",
        dryRun=true
)

public class CukesRunner {
}
