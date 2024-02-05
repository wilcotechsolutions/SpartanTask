package com.spartans.step_definitions;

import com.spartans.pages.*;
import org.openqa.selenium.WebElement;

public class BaseStepDef {

    protected String expectedUploadedFileName;
    protected SpartanHomePage spartanHomePage = new SpartanHomePage();
    protected SpartanCrudOperationPage spartanCrudOperationPage = new SpartanCrudOperationPage();
    protected SpartanDetailsPage spartanDetailsPage = new SpartanDetailsPage();
    protected SpartanEditPage spartanEditPage = new SpartanEditPage();
    protected SpartanAddPage addSpartanPage = new SpartanAddPage();
    protected HerokuappPage herokuappPage = new HerokuappPage();

    protected void clickOnTheButton(String buttonName, String pageName) {
        switch (pageName) {
            case "Spartan Crud Operation" -> spartanCrudOperationPage.clickOnTheButton(buttonName);
            case "Spartan Edit" -> spartanEditPage.clickOnTheButton(buttonName);
            case "Add Spartan" -> addSpartanPage.clickOnTheButton(buttonName);
        }
    }

    protected void enterDataToTheInputBox(String data, String inputBoxName, String pageName) throws InterruptedException {
        switch (pageName) {
            case "Spartan Crud Operation" -> spartanCrudOperationPage.enterDataToTheInputBox(data, inputBoxName);
            case "Spartan Edit" -> spartanEditPage.enterDataToTheInputBox(data, inputBoxName);
            case "Add Spartan" -> addSpartanPage.enterDataToTheInputBox(data, inputBoxName);
        }
    }

    protected void clickHerokuappButton(String buttonName) {
        switch (buttonName) {
            case "File Upload" -> herokuappPage.fileUpload.click();
            case "Broken Images" -> herokuappPage.brokenImages.click();
        }
    }

    protected void uploadFile(String filePath) {
        String nameDirectory = System.getProperty("user.dir");
        String finalPath = nameDirectory + "/" + filePath;
        herokuappPage.chooseFile.sendKeys(finalPath);
        herokuappPage.uploadFile.click();

        String[] arr = filePath.split("/");
        expectedUploadedFileName = arr[arr.length - 1];
    }

    public boolean isImageBroken(WebElement image) {
        if (image.getAttribute("naturalWidth").equals("0")) {
            System.out.println(image.getAttribute("outerHTML") + " is broken.");
            return true;
        }
        return false;
    }

}
