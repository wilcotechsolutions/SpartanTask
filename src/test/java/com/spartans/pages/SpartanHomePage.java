package com.spartans.pages;

import com.spartans.utilities.BrowserUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpartanHomePage extends BasePage{

    @FindBy(xpath = "//small[1]")
    WebElement webDataLink;

    @FindBy(xpath = "//small[2]")
    WebElement apiDocLink;

    @FindBy(xpath = "//small[3]")
    WebElement databaseLink;

    public void clickOnTheButton(String buttonName) {
        WebElement button = switch (buttonName) {
            case "Web Data" -> webDataLink;
            case "API Doc" -> apiDocLink;
            case "Database" -> databaseLink;
            default -> null;
        };
        BrowserUtility.clickOn(button);
    }

}
