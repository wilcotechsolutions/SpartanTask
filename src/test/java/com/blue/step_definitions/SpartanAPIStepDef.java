package com.blue.step_definitions;

import com.blue.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.*;

public class SpartanAPIStepDef {

    Response response;

    @When("Send a {string} request to the {string}")
    public void sendARequestToThe(String requestType, String endpoint) {
        RestAssured.baseURI = ConfigurationReader.get("spartan.apiUrl");
        response = given()
                .accept(ContentType.JSON)
                .when().get(endpoint);
    }

    @When("Send a {string} request to the {string} with data {string} {string}")
    public void sendARequestToTheWithData(String requestType, String endpoint, String id, String name) {
        RestAssured.baseURI = ConfigurationReader.get("spartan.apiUrl");
        endpoint = endpoint + "/" + id;
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("name", name);
        System.out.println("payloadData = " + payloadData);
        response = given()
                .accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .and().body(payloadData)
                .when().patch(endpoint);
    }

    @When("Send a {string} request to the {string} with data {string} {string} {string}")
    public void sendARequestToTheWithData(String requestType, String endpoint, String name, String gender, String phone) {
        RestAssured.baseURI = ConfigurationReader.get("spartan.apiUrl");
        Map<String, Object> payloadData = createPayloadData(name, gender, phone);
        System.out.println("payloadData = " + payloadData);
        response = given()
                .accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .and().body(payloadData)
                .when().post(endpoint);
    }

    @When("Send a {string} request to the {string} with data {string} {string} {string} {string}")
    public void sendARequestToTheWithData(String requestType, String endpoint, String id, String name, String gender, String phone) {
        RestAssured.baseURI = ConfigurationReader.get("spartan.apiUrl");
        endpoint = endpoint + "/" + id;
        System.out.println("endpoint = " + endpoint);
        Map<String, Object> payloadData = createPayloadData(name, gender, phone);
        System.out.println("payloadData = " + payloadData);
        response = given()
                .accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .and().body(payloadData)
                .when().put(endpoint);
    }

    @When("Send a {string} request to the {string} with data {string}")
    public void sendARequestToTheWithData(String requestType, String endpoint, String data) {
        RestAssured.baseURI = ConfigurationReader.get("spartan.apiUrl");
        endpoint = endpoint.contains("id") ? endpoint + "/" + data : endpoint + data;
        System.out.println("endpoint = " + endpoint);
        if(requestType.equals("GET")){
            response = given()
                    .accept(ContentType.JSON)
                    .and().contentType(ContentType.JSON)
                    .when().get(endpoint);
        }
        if(requestType.equals("DELETE")){
            response = given()
                    .accept(ContentType.JSON)
                    .and().contentType(ContentType.JSON)
                    .and().auth().basic("admin", "admin")
                    .when().delete(endpoint);
        }
    }

    private Map<String, Object> createPayloadData(String name, String gender, String phone) {
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("name", name);
        payloadData.put("gender", gender);
        payloadData.put("phone", phone);
        return payloadData;
    }

    @Then("Verify that respond {string} is {string}")
    public void verifyThatRespondIs(String dataType, String expectedData) {
        String actualData = switch (dataType) {
            case "status code" -> String.valueOf(response.statusCode());
            case "content type" -> response.contentType();
            case "name" -> response.path("data.name") == null ? response.path("name") : response.path("data.name");
            case "gender" -> response.path("data.gender") == null ? response.path("gender") : response.path("data.gender");
            case "phone" -> response.path("data.phone") == null ? response.path("phone").toString() : response.path("data.phone").toString();
            default -> null;
        };
        System.out.println("expectedData = " + expectedData);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(expectedData, actualData);
    }

    @Then("Verify that respond {string} contains {string}")
    public void verifyThatRespondContains(String names, String data) {
        String key = data.toLowerCase();
        JsonPath jsonPath = response.jsonPath();
        List<String> actualNames = jsonPath.getList("content.name");
        System.out.println("actualNames = " + actualNames);
        System.out.println(key);
        for (String each : actualNames) {
            Assert.assertTrue(each.toLowerCase().contains(key));
        }
    }

}
