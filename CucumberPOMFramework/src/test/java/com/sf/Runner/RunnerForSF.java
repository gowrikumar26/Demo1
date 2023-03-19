package com.sf.Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/featureForSF.feature"},
		glue = {"com.sf.StepDefinition"},
		monochrome = true,
		dryRun = false)

public class RunnerForSF {

}
