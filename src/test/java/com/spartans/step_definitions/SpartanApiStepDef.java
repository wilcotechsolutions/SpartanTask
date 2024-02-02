package com.spartans.step_definitions;
import com.spartans.pages.SpartanPOJO;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class SpartanApiStepDef {
    Response response;
    List<String> spartanNames;
    public static String apiName;

    @When("User send a request to API with the ID of {int}")
    public void user_send_a_request_to_api_with_the_id_of(Integer int1) {

        response = given().accept(ContentType.JSON)
                .pathParam("id", int1)
                .get("/api/spartans/{id}");


        response.prettyPrint();
        Assert.assertEquals("response code does not match",200, response.statusCode());
        Assert.assertEquals("application/json", response.contentType());
        Assert.assertEquals("chunked",response.header("Transfer-Encoding"));

        JsonPath jsonPath = response.jsonPath();
        apiName = jsonPath.getString("name");
        System.out.println("Jsonpath apiName = " + apiName);

    }
/*
    @Then("Reply from the API should be the same as UI")
    public void reply_from_the_api_should_be_the_same_as_ui() {

        Assert.assertEquals("UI vs API don't match", new SpartansUISteps().UI_name, apiName);
        System.out.println(SpartansUISteps.UI_name);
        System.out.println(apiName);
    }

 */

    @Then("Assert API results with the info of Spartan's {int} ,  {string} , {string} and {string}")
    public void assert_api_results_with_the_info_of_spartan_s_and(Integer int1, String string, String string2, String string3) {

        response = given().accept(ContentType.JSON)
                .pathParam("id", int1)
                .get("/api/spartans/{id}");

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get("name"), string);
        System.out.println("jsonPath.get(\"name\") = " + jsonPath.get("name"));
        Assert.assertEquals(jsonPath.get("gender"), string2);
        System.out.println("jsonPath.get(\"gender\") = " + jsonPath.get("gender"));
        Assert.assertEquals(jsonPath.getString("phone"), string3);
        System.out.println("jsonPath.getString(\"phone\") = " + jsonPath.getString("phone"));

    }


    @When("User checks and asserts API replies using the Spartan with the ID of {int}, {string}, {string}")
    public void user_checks_and_asserts_api_replies_using_the_spartan_with_the_id_of(Integer int1, String expectedName, String expectedGender) {

        given().accept(ContentType.JSON)
                .pathParam("id", int1)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(int1), "name", Matchers.equalTo(expectedName),
                        "gender", Matchers.equalTo(expectedGender));
    }

    @And("Assert API results using Hamcrest with the info of Spartan's {int} ,  {string} , {string} and {long}")
    public void assert_api_results_using_hamcrest_with_the_info_of_spartan_s_and(Integer int1, String string, String string2, Long long1) {

        given().accept(ContentType.JSON)
                .pathParam("id", int1)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("name", Matchers.equalTo(string),
                        "gender", Matchers.equalTo(string2),
                        "phone", Matchers.equalTo(long1));

    }

    @When("User checks and asserts API replies using De-Serialization Map Method of a Spartan with the ID of {int} and name {string}")
    public void user_checks_and_asserts_api_replies_using_de_serialization_map_method_of_a_spartan_with_the_id_of_and_name(Integer int1, String expectedName) {

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", int1)
                .when().get("/api/spartans/{id}");

        Map<String, Object> map = response.body().as(Map.class);
        Object actualName = map.get("name");

        Assert.assertEquals(actualName, expectedName);
        System.out.println(map.get("name"));
    }



    @When("User checks and asserts API replies using POJO of a Spartan with the ID of {int}, {string}")
    public void user_checks_and_asserts_api_replies_using_pojo_of_a_spartan_with_the_id_of(Integer int1, String expectedName) {

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", int1)
                .when().get("/api/spartans/{id}");

        SpartanPOJO spartans_pojo = response.body().as(SpartanPOJO.class);
        Assert.assertEquals("Name does not match", spartans_pojo.getName(), expectedName);

        System.out.println(spartans_pojo.toString());
        System.out.println(spartans_pojo.getName());

    }

    @When("User checks and asserts API replies using GSON of a Spartan with the ID of {int}")
    public void user_checks_and_asserts_api_replies_using_gson_of_a_spartan_with_the_id_of(Integer int1) {

        Gson gson=new Gson();

        String json="{\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Meade\",\n" +
                "        \"gender\": \"Male\",\n" +
                "        \"phone\": 3584128232\n" +
                "    }";

        SpartanPOJO spartanMeta= gson.fromJson(json,SpartanPOJO.class);

        System.out.println(spartanMeta.toString());


    }
}
