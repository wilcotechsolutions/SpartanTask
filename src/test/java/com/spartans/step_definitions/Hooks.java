package com.spartans.step_definitions;

import com.spartans.utilities.ConfigurationReader;
import com.spartans.utilities.Driver;
import com.spartans.utilities.LoggerUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@spartansUI")
    public void setUpSpartanUI() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.get("spartan.homepageUrl"));
        LoggerUtility.logInfo("Browser set up completed and navigated to the Spartan Home Page");
    }

    @Before("@herokuUI")
    public void setUpHeroUI() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.get("herokuapp"));
        LoggerUtility.logInfo("Browser set up completed and navigated to the HerookuApp Page");
    }

    @After("@spartansUI")
    public void tearDownSpartan(Scenario scenario) {
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
        LoggerUtility.logInfo("Browser closed");
    }

    @After("@herokuUI")
    public void tearDownHeroku(Scenario scenario) {
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
        LoggerUtility.logInfo("Browser closed");
    }

    @Before("@spartansAPI")
    public void setUpAPI() {
        RestAssured.baseURI = ConfigurationReader.get("spartan.apiUrl") + "/api/spartans";
    }

}
