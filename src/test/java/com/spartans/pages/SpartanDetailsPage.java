package com.spartans.pages;

import com.spartans.utilities.BrowserUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SpartanDetailsPage extends BasePage{

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="gender")
    public WebElement gender;

    @FindBy(id="phone")
    public WebElement phone;

    public String getActualData(String fieldName){
        String data = "";
        wait.until(ExpectedConditions.visibilityOf(name));
        data = switch (fieldName) {
            case "Name" -> name.getAttribute("value");
            case "Gender" -> gender.getAttribute("value");
            case "Phone" -> phone.getAttribute("value");
            default -> data;
        };
        return  data;
    }

}
