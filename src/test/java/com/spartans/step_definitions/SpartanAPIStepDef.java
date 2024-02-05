package com.spartans.step_definitions;

import static com.spartans.utilities.ApiUtility.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.*;

public class SpartanAPIStepDef {

    private Response response;

    @When("Send a request to display all Spartans")
    public void sendAGETRequestToTheToDisplayAllSpartans() {
        response = sendGetRequestToEndpoint("");
    }

    @When("Send a request to add a new Spartan {string} {string} {string}")
    public void sendARequestToAddANewSpartan(String name, String gender, String phone) {
        Map<String, Object> payLoad = createPayload(name, gender, phone);
        response = sendPostRequestWithPayload(payLoad);
    }

    @When("Send a request to display last created Spartan")
    public void sendARequestToDisplayLastCreatedSpartan() {
        int maxId = getLastCreatedSpartanId();
        response = sendGetRequestToEndpoint("/" + maxId);
    }

    @When("Send a request to update the last created Spartan {string} {string} {string}")
    public void sendARequestToUpdateTheLastCreatedSpartan(String name, String gender, String phone) {
        Map<String, Object> payLoad = createPayload(name, gender, phone);
        int maxId = getLastCreatedSpartanId();
        response = sendPutRequestToEndpointWithPayload("/" + maxId, payLoad);
    }

    @When("Send a request to partially update the last created Spartan {string}")
    public void sendARequestToPartiallyUpdateTheLastCreatedSpartan(String name) {
        Map<String, Object> payLoad = createPayload(name);
        int maxId = getLastCreatedSpartanId();
        response = sendPatchRequestToEndpointWithPayload("/" + maxId, payLoad);
    }

    @When("Send a request to search for the last created Spartan {string}")
    public void sendARequestToSearchForTheLastCreatedSpartan(String data) {
        response = sendGetRequestToEndpoint("/search?nameContains=" + data);
    }

    @When("Send a request to delete the last created Spartan")
    public void sendARequestToDeleteTheLastCreatedSpartan() {
        int maxId = getLastCreatedSpartanId();
        response = sendDeleteRequestToEndpoint("/" + maxId);
    }

    @Then("Verify that response {string} is {string}")
    public void verifyThatResponseIs(String dataType, String expectedData) {
        String actualData = getActualData(dataType);
        System.out.println("expectedData = " + expectedData);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(expectedData, actualData);
    }

    @Then("Verify that response {string} list contains {string}")
    public void verifyThatResponseContains(String dataType, String expectedData) {
        List<String> actualDataList = getActualDataList(dataType);
        for (String each : actualDataList) {
            Assert.assertTrue(each.toLowerCase().contains(expectedData.toLowerCase()));
        }
    }

    @Then("Verify that response body is not empty")
    public void verifyThatResponseBodyIsNotEmpty() {
        Assert.assertNotNull(response.body());
    }

}
