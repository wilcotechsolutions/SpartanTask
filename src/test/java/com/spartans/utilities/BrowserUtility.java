package com.spartans.utilities;

import com.spartans.pages.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class BrowserUtility {

    public static WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(12));

    public static void clickOn(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void enterData(WebElement inputBox, String data) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(inputBox));
        inputBox.clear();
        Thread.sleep(1000);
        inputBox.sendKeys(data);
    }

}
