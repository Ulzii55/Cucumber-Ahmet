package com.test.smartbear.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/smartbear", //feature files location
        glue = "com/test/smartbear/stepdefinitions",//step definitions files location
        dryRun =false,
        tags="@regression",
        plugin={"pretty","html:target/uireport.html","rerun:target/uiFailedTests.txt"}
)
public class SmartBearRunner {
}
