package com.spartans.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HerokuappPage extends BasePage{

    @FindBy(linkText="Broken Images")
    public WebElement brokenImages;

    @FindBy(linkText="File Upload")
    public WebElement fileUpload;

    @FindBy(id="file-upload")
    public WebElement chooseFile;

    @FindBy(id="file-submit")
    public WebElement uploadFile;

    @FindBy(css="#content h3")
    public WebElement uploadSuccessText;

    @FindBy(id="uploaded-files")
    public WebElement uploadFileName;

    @FindBy(css="#content img")
    public List<WebElement> images;


}
