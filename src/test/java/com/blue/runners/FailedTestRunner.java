package com.blue.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                "html:target/failed-cucumber-reports.html",
                "json:target/cucumber-reports/failed-cucumber.json",
                "junit:target/cucumber-reports/failed-cucumber.xml",
                "pretty",
        },
        features = "@target/rerun.txt",
        glue = "com/blue/step_definitions"
)

public class FailedTestRunner {
}
