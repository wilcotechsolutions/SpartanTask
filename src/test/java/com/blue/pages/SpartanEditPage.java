package com.blue.pages;

import com.blue.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SpartanEditPage extends BasePage {

    @FindBy(id="name")
    public WebElement nameInputBox;

    @FindBy(id="gender")
    public WebElement genderDropdown;

    @FindBy(id="phone")
    public WebElement phoneInputBox;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement updateButton;

    @FindBy(xpath="//a[contains(text(),'Cancal')]")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[contains(text(),'Back to the List')]")
    public WebElement backToTheListButton;

    public void clickOnTheButton(String buttonName) {
        WebElement button = switch (buttonName) {
            case "Update" -> updateButton;
            case "Cancel" -> cancelButton;
            case "Back to the List" -> backToTheListButton;
            default -> null;
        };
        BrowserUtils.clickOn(button);
    }

    public void enterDataToTheInputBox(String data, String inputBoxName) throws InterruptedException {
        WebElement inputBox = switch (inputBoxName) {
            case "Name Input Box" -> nameInputBox;
            case "Phone Input Box" -> phoneInputBox;
            default -> null;
        };
        BrowserUtils.enterData(inputBox, data);
    }

    public String getActualData(String fieldName) {
        String data = "";
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        data = switch (fieldName) {
            case "SUCCESS MESSAGE" -> successMessage.getText();
            default -> data;
        };
        return data;
    }

}
