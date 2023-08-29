package tek.bdd.capstone.runner;

import io.cucumber.junit.Cucumber; 
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//We use the @RunWith from JUnit and then use the CucumberOptions to setup the TestRunner class
//and here we type our code before the class name

@RunWith(Cucumber.class)
@CucumberOptions
(
        tags = "@Smoke",
        	 // Specifies which scenario(s) to run using the given tag
        features = ("classpath:features"), // Specifies the path to the feature files
        glue = "tek.bdd.capstone", // Specifies the package containing step definition classes
        dryRun = false, // If set to true, it prints the steps without executing them; if false, it runs the tests
        plugin = { // Specifies the plugins to generate different types of reports
                "pretty",
                "html:target/htmlReports/cucumber-pretty.html",
                "json:target/jsonReports/cucumber.json" },
        snippets = CAMELCASE, // Specifies the naming convention for
                                                                                    // step definitions snippets
        monochrome = true // Displays the console output in a more readable format
)
//Note: This class is the test runner class for executing Cucumber tests
public class TestRunner {

}
		