package com.spartans.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                "html:target/cucumber-reports/failed-cucumber.html",
                "json:target/cucumber-reports/failed-cucumber.json",
               // "junit:target/cucumber-reports/failed-cucumber.xml",
                //"pretty",
        },
        features = "@target/rerun.txt",
        glue = "com/spartans/step_definitions"
)

public class FailedTestRunner {
}
