package com.spartans.pages;

import com.spartans.utilities.BrowserUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SpartanAddPage extends BasePage {

    @FindBy(id="name")
    public WebElement nameInputBox;

    @FindBy(id="genderSelect")
    public WebElement genderDropdown;

    @FindBy(id="phone")
    public WebElement phoneInputBox;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath="//a[contains(text(),'Cancal')]")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[contains(text(),'Back to the List')]")
    public WebElement backToTheListButton;

    public void clickOnTheButton(String buttonName) {
        WebElement button = switch (buttonName) {
            case "Submit" -> submitButton;
            case "Cancel" -> cancelButton;
            case "Back to the List" -> backToTheListButton;
            default -> null;
        };
        BrowserUtility.clickOn(button);
    }

    public void enterDataToTheInputBox(String data, String inputBoxName) throws InterruptedException {
        WebElement inputBox = switch (inputBoxName) {
            case "Name Input Box" -> nameInputBox;
            case "Phone Input Box" -> phoneInputBox;
            default -> null;
        };
        BrowserUtility.enterData(inputBox, data);
    }

    public void selectFromDropdown(String option, String dropdownName) {
        if(dropdownName.equals("Gender")){
            wait.until(ExpectedConditions.visibilityOf(genderDropdown));
            Select select = new Select(genderDropdown);
            select.selectByVisibleText(option);
        }
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
