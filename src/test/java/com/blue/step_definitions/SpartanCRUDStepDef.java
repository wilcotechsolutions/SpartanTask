package com.blue.step_definitions;

import com.blue.pages.SpartanCrudOperationPage;
import com.blue.pages.SpartanDetailsPage;
import com.blue.pages.SpartanHomePage;
import com.blue.utilities.LoggerUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SpartanCRUDStepDef {

    SpartanHomePage spartanHomePage = new SpartanHomePage();
    SpartanCrudOperationPage spartanCrudOperationPage = new SpartanCrudOperationPage();
    SpartanDetailsPage spartanDetailsPage = new SpartanDetailsPage();

    @Given("Commander navigates to the Spartan Crud Operation Page")
    public void commander_navigates_to_the_spartan_crud_operation_page() {
        spartanHomePage.clickOnTheButton("Web Data");
        LoggerUtil.logInfo("Commander navigates to the Spartan Crud Operation page");
    }
    @When("Commander enters {string} to the {string} on the Spartan Crud Operation Page")
    public void commander_enters_to_the_on_the_spartan_crud_operation_page(String name, String textBoxName) throws InterruptedException {
        spartanCrudOperationPage.enterDataToTheTextBox(name, textBoxName);
        LoggerUtil.logInfo("Commander enters name to the name search box on the Spartan Crud Operation Page");
    }
    @When("Commander clicks on the {string} button on the Spartan Crud Operation Page")
    public void commander_clicks_on_the_button_on_the(String buttonName) {
        spartanCrudOperationPage.clickOnTheButton(buttonName);
        LoggerUtil.logInfo("Commander clicks on the Search button on the Spartan Crud Operation Page");
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
        spartanCrudOperationPage.clickOnTheButtonForTheSpartanId("View", spartanId);
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

}
