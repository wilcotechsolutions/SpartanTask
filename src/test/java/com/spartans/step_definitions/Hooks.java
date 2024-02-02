package com.spartans.step_definitions;

import com.spartans.utilities.ConfigurationReader;
import com.spartans.utilities.DBUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.spartans.utilities.Driver;
import com.spartans.utilities.LoggerUtil;
import io.restassured.RestAssured;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before()
    public void setUpUI() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.get("spartan.homepageUrl"));
        LoggerUtil.logInfo("Browser set up completed and navigated to the Home Page");
        RestAssured.baseURI= ConfigurationReader.get("spartan.apiUrl");
    }

    @After()
    public void tearDownUI() {
        Driver.closeDriver();
        LoggerUtil.logInfo("Browser closed");
    }

    @Before("@db")
    public void connectDB(){
        DBUtils.createConnection();
    }
    @After("@db")
    public void closeDB(){
        DBUtils.destroy();
    }

}
