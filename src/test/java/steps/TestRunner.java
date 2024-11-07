package steps;


import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner {
    @Test
    public void runCucumberTests() {
    }
}
