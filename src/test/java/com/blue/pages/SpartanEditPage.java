package com.blue.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpartanEditPage extends Serializers.Base {

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="gender")
    public WebElement gender;

    @FindBy(id="phone")
    public WebElement phone;

    @FindBy(id="gender")
    public WebElement updateButton;

    @FindBy(id="phone")
    public WebElement CancelButton;

}
