package com.blue.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpartanHomePage extends BasePage{

    @FindBy(partialLinkText = "Web Data")
    public WebElement webDataLink;

    public void clickOnTheButton(String buttonName){
        if(buttonName.equals("Web Data")){
            webDataLink.click();
        }
    }

}
