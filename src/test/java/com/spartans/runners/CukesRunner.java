package com.spartans.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "pretty",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/spartans/step_definitions",
        dryRun = false,
        tags = "@hero"
)

public class CukesRunner {
}
