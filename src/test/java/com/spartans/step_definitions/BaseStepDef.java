package com.spartans.step_definitions;

import com.spartans.pages.*;
import org.openqa.selenium.WebElement;

public class BaseStepDef {

    protected SpartanHomePage spartanHomePage = new SpartanHomePage();
    protected SpartanCrudOperationPage spartanCrudOperationPage = new SpartanCrudOperationPage();
    protected SpartanDetailsPage spartanDetailsPage = new SpartanDetailsPage();
    protected SpartanEditPage spartanEditPage = new SpartanEditPage();
    protected SpartanAddPage spartanAddPage = new SpartanAddPage();
    protected HerokuAppPage herokuAppPage = new HerokuAppPage();

    protected void clickOnTheButton(String buttonName, String pageName) {
        switch (pageName) {
            case "Spartan Home" -> spartanHomePage.clickOnTheButton(buttonName);
            case "Spartan Crud Operation" -> spartanCrudOperationPage.clickOnTheButton(buttonName);
            case "Spartan Edit" -> spartanEditPage.clickOnTheButton(buttonName);
            case "Spartan Add" -> spartanAddPage.clickOnTheButton(buttonName);
        }
    }

    protected void enterDataToTheInputBox(String data, String inputBoxName, String pageName) throws InterruptedException {
        switch (pageName) {
            case "Spartan Crud Operation" -> spartanCrudOperationPage.enterDataToTheInputBox(data, inputBoxName);
            case "Spartan Edit" -> spartanEditPage.enterDataToTheInputBox(data, inputBoxName);
            case "Spartan Add" -> spartanAddPage.enterDataToTheInputBox(data, inputBoxName);
        }
    }

    protected void clickHerokuAppButton(String buttonName) {
        switch (buttonName) {
            case "File Upload" -> herokuAppPage.fileUpload.click();
            case "Broken Images" -> herokuAppPage.brokenImages.click();
            case "Hovers" -> herokuAppPage.hovers.click();

        }
    }

    protected void uploadFile(String filePath) {
        String nameDirectory = System.getProperty("user.dir");
        String finalPath = nameDirectory + "/" + filePath;
        herokuAppPage.chooseFile.sendKeys(finalPath);
        herokuAppPage.uploadFile.click();
    }

    public boolean isImageBroken(WebElement image) {
        return image.getAttribute("naturalWidth").equals("0");
    }

}
