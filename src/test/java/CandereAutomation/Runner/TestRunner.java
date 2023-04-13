package CandereAutomation.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features",
		glue="CandereAutomation.stepdefs",
		tags="@IconsHadle",
		plugin={"pretty", // to generate reports
	            "html:target/html/htmlreport.html",
	            "json:target/json/file.json",
	            },
		monochrome=true,
		publish=true,
		dryRun= false
	
)

public class TestRunner {
	
	
}
