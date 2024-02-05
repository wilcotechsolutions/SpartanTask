package com.spartans.step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class SpartanUIStepDef extends BaseStepDef{

    int preDeletionTotal;

    @When("Commander enters {string} to the {string} on the {string} page")
    public void commander_enters_to_the_on_the_spartan_crud_operation_page(String name, String inputBoxName, String pageName) throws InterruptedException {
        enterDataToTheInputBox(name, inputBoxName, pageName);
    }

    @When("Commander clicks on the {string} button on the {string} page")
    public void commander_clicks_on_the_button_on_the(String buttonName, String pageName) {
        clickOnTheButton(buttonName, pageName);
    }

    @Then("Verify that the {string} data on the table are {string} on the Spartan Crud Operation Page")
    public void verify_that_the_on_the_table_are_on_the(String columnName, String expectedResult) {
        String actualResult = spartanCrudOperationPage.getColumnData(columnName).stream().distinct().toList().get(0);
        System.out.println("Actual Result = " + actualResult);
        System.out.println("Expected Result = " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @And("Commander checks the {string} before deletion")
    public void commanderChecksTheBeforeDeletion(String total) {
        preDeletionTotal = Integer.parseInt(spartanCrudOperationPage.getData(total));
    }

    @Then("Verify that {string} decreased by {int}")
    public void verifyThatDecreasedBy(String total, int amount) {
        int postDeletionTotal = Integer.parseInt(spartanCrudOperationPage.getData(total));
        Assert.assertEquals(preDeletionTotal-postDeletionTotal,amount);
    }

    @Then("Verify that {string} is equal to {string}")
    public void verify_that_totalResult_is_decreased_by_1(String data1, String data2) {
        String actualResult1 = spartanCrudOperationPage.getData(data1);
        String actualResult2 = spartanCrudOperationPage.getData(data2);
        System.out.println("actualResult1 = " + actualResult1);
        System.out.println("actualResult2 = " + actualResult2);
        Assert.assertEquals(actualResult1, actualResult2);
    }

    @When("Commander clicks on the {string} button of Spartan named {string} after search")
    public void commander_clicks_on_the_button_of_the_first_spartan_after_search(String buttonName, String spartanName) {
        spartanCrudOperationPage.clickOnTheButtonForTheFirstSpartanAfterSearch(buttonName, spartanName);
    }

    @Then("Verify that the {string} of the Spartan is {string} on the Spartan Details Page")
    public void verify_that_the_of_the_spartan_is_on_the_spartan_details_page(String fieldName, String data) {
        String expectedResult = data;
        String actualResult = spartanDetailsPage.getActualData(fieldName);
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @And("Commander select {string} from the {string} dropdown on the {string} page")
    public void commenderSelectFromTheOnThePage(String option, String dropdownName, String pageName) {
        if(pageName.equals("Add Spartan")){
            spartanAddPage.selectFromDropdown(option, dropdownName);
        }
    }

    @Then("Verify {string} is {string} on the {string} page")
    public void verifiesTheOnThePage(String fieldName, String expectedMessage, String pageName) {
        String expectedResult = expectedMessage;
        String actualResult = "";
        if(pageName.equals("Spartan Edit")){
            actualResult = spartanEditPage.getActualData(fieldName);
        }else if(pageName.equals("Spartan Add")){
            actualResult = spartanAddPage.getActualData(fieldName);
        }
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
    }

}
