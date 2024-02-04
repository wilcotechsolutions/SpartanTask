package com.blue.step_definitions;

import com.blue.utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.blue.utilities.Driver;
import com.blue.utilities.LoggerUtil;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("web")
    public void setUpUI() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.get("spartan.homepageUrl"));
        LoggerUtil.logInfo("Browser set up completed and navigated to the Home Page");
    }

    @After("web")
    public void tearDownUI(Scenario scenario) {
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
        LoggerUtil.logInfo("Browser closed");
    }

}
