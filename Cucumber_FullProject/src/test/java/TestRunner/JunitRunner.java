package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\evans\\git\\Cucumber_FullProject\\Cucumber_FullProject\\Features"},
		glue = {"step_Definitions","Utilities"},
				plugin= {
	    "pretty",
	    "html:C:\\Users\\evans\\git\\Cucumber_FullProject\\Cucumber_FullProject\\target\\htmlReport\\cucumberReport.html ",
	    "json:C:\\Users\\evans\\git\\Cucumber_FullProject\\Cucumber_FullProject\\target\\jsonCucumberReport\\json "
		}, 
		
		monochrome = false,
		dryRun = true,
		tags="@smoke and @regression"
	)


public class JunitRunner {

}
