package com.blue.step_definitions;

import com.blue.pages.*;
import com.blue.utilities.LoggerUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SpartanCRUDStepDef {

    SpartanHomePage spartanHomePage = new SpartanHomePage();
    SpartanCrudOperationPage spartanCrudOperationPage = new SpartanCrudOperationPage();
    SpartanDetailsPage spartanDetailsPage = new SpartanDetailsPage();
    SpartanEditPage spartanEditPage = new SpartanEditPage();
    AddSpartanPage addSpartanPage = new AddSpartanPage();

    @Given("Commander navigates to the Spartan Crud Operation Page")
    public void commander_navigates_to_the_spartan_crud_operation_page() {
        spartanHomePage.clickOnTheButton("Web Data");
        LoggerUtil.logInfo("Commander navigates to the Spartan Crud Operation page");
    }
    @When("Commander enters {string} to the {string} on the {string} page")
    public void commander_enters_to_the_on_the_spartan_crud_operation_page(String name, String inputBoxName, String pageName) throws InterruptedException {
        enterDataToTheInputBox(name, inputBoxName, pageName);
        LoggerUtil.logInfo("Commander enters name to the name search box on the Spartan Crud Operation page");
    }
    @When("Commander clicks on the {string} button on the {string} page")
    public void commander_clicks_on_the_button_on_the(String buttonName, String pageName) {
        clickOnTheButton(buttonName, pageName);
        LoggerUtil.logInfo("Commander clicks on the Search button on the Spartan Crud Operation");
    }
    @Then("Verify that the {string} data on the table are {string} on the Spartan Crud Operation Page")
    public void verify_that_the_on_the_table_are_on_the(String columnName, String expectedResult) {
        String actualResult = spartanCrudOperationPage.getColumnData(columnName).stream().distinct().toList().get(0);
        System.out.println("Actual Result = " + actualResult);
        System.out.println("Expected Result = " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
        LoggerUtil.logInfo("Verify that names on the table are name on the Spartan Crud Operation Page");
    }
    @Then("Verify that {string} is equal to {string}")
    public void verify_that_totalResult_is_equal_to_total(String data1, String data2) {
        String actualResult1 = spartanCrudOperationPage.getData(data1);
        String actualResult2 = spartanCrudOperationPage.getData(data2);
        System.out.println("actualResult1 = " + actualResult1);
        System.out.println("actualResult2 = " + actualResult2);
        Assert.assertEquals(actualResult1, actualResult2);
        LoggerUtil.logInfo("Verify that Total Result is equal to Total");
    }

    @When("Commander clicks on the {string} button of the Spartan ID {string}")
    public void commander_clicks_on_the_button_of_the_spartan_id(String buttonName, String spartanId) {
        spartanCrudOperationPage.clickOnTheButtonForTheSpartanId(buttonName, spartanId);
        LoggerUtil.logInfo("Commander clicks on the View button of the Spartan ID");
    }

    @Then("Verify that the {string} of the Spartan is {string} on the Spartan Details Page")
    public void verify_that_the_of_the_spartan_is_on_the_spartan_details_page(String fieldName, String data) {
        String expectedResult = data;
        String actualResult = spartanDetailsPage.getActualData(fieldName);
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
        LoggerUtil.logInfo("Verify that the data of the Spartan is data on the Spartan Detail Page");
    }

    @And("Commander select {string} from the {string} dropdown on the {string} page")
    public void commenderSelectFromTheOnThePage(String option, String dropdownName, String pageName) {
        if(pageName.equals("Add Spartan")){
            addSpartanPage.selectFromDropdown(option, dropdownName);
        }
    }

    @Then("Verify {string} is {string} on the {string} page")
    public void verifiesTheOnThePage(String fieldName, String expectedMessage, String pageName) {
        String expectedResult = expectedMessage;
        String actualResult = "";
        if(pageName.equals("Spartan Edit")){
            actualResult = spartanEditPage.getActualData(fieldName);
        }else if(pageName.equals("Add Spartan")){
            actualResult = addSpartanPage.getActualData(fieldName);
        }
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
        LoggerUtil.logInfo("Verify that the data of the Spartan is data on the Spartan Detail Page");
    }

    public void clickOnTheButton(String buttonName, String pageName){
        switch (pageName) {
            case "Spartan Crud Operation" -> spartanCrudOperationPage.clickOnTheButton(buttonName);
            case "Spartan Edit" -> spartanEditPage.clickOnTheButton(buttonName);
            case "Add Spartan" -> addSpartanPage.clickOnTheButton(buttonName);
        }
    }

    public void enterDataToTheInputBox(String data, String inputBoxName, String pageName) throws InterruptedException {
        switch (pageName) {
            case "Spartan Crud Operation" -> spartanCrudOperationPage.enterDataToTheInputBox(data, inputBoxName);
            case "Spartan Edit" -> spartanEditPage.enterDataToTheInputBox(data, inputBoxName);
            case "Add Spartan" -> addSpartanPage.enterDataToTheInputBox(data, inputBoxName);
        }
    }
}
