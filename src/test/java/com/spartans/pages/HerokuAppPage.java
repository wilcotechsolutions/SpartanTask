package com.spartans.pages;

import com.spartans.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HerokuAppPage extends BasePage{

    @FindBy(linkText="Broken Images")
    public WebElement brokenImages;

    @FindBy(linkText="File Upload")
    public WebElement fileUpload;

    @FindBy(linkText="Hovers")
    public WebElement hovers;

    @FindBy(id="file-upload")
    public WebElement chooseFile;

    @FindBy(id="file-submit")
    public WebElement uploadFile;

    @FindBy(css="#content h3")
    public WebElement uploadSuccessText;

    @FindBy(id="uploaded-files")
    public WebElement uploadedFileName;

    @FindBy(css="#content img")
    public List<WebElement> images;

    @FindBy(xpath="//div[@class='figure'][1]")
    public WebElement figure;

    @FindBy(xpath="//h5[contains(text(),'name: user1')]")
    public WebElement userInfo;

    public String getActualAdditionalInformation() {
        Actions action = new Actions(Driver.get());
        action.moveToElement(figure).perform();
        return userInfo.getText();
    }

}
