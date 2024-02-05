package com.spartans.step_definitions;

import com.spartans.pages.*;

public class BaseStepDef {

    protected SpartanHomePage spartanHomePage = new SpartanHomePage();
    protected SpartanCrudOperationPage spartanCrudOperationPage = new SpartanCrudOperationPage();
    protected SpartanDetailsPage spartanDetailsPage = new SpartanDetailsPage();
    protected SpartanEditPage spartanEditPage = new SpartanEditPage();
    protected SpartanAddPage spartanAddPage = new SpartanAddPage();

    protected void clickOnTheButton(String buttonName, String pageName){
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

}
