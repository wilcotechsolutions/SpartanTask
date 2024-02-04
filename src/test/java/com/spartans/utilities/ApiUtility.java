package com.spartans.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtility {

    static Response response;
    static ContentType contentType = ContentType.valueOf(ConfigurationReader.get("spartan.api.content_type"));
    static String username = ConfigurationReader.get("spartan.api.username");
    static String password = ConfigurationReader.get("spartan.api.password");

    public static Response sendGetRequestToEndpoint(String endpoint) {
        response = given()
                .accept(contentType)
                .and().contentType(contentType)
                .when().get(endpoint);
        return response;
    }

    public static Response sendDeleteRequestToEndpoint(String endpoint) {
        response = given()
                .accept(contentType)
                .and().contentType(contentType)
                .when().delete(endpoint);
        return response;
    }

    public static Response sendPostRequestWithPayload(Map<String, Object> payLoad){
        response = given()
                .accept(contentType)
                .and().contentType(contentType)
                .and().auth().basic(username,password)
                .and().body(payLoad)
                .when().post();
        return response;
    }

    public static Response sendPutRequestToEndpointWithPayload(String endpoint, Map<String, Object> payLoad){
        response = given()
                .accept(contentType)
                .and().contentType(contentType)
                .and().auth().basic(username,password)
                .and().body(payLoad)
                .when().put(endpoint);
        return response;
    }

    public static Response sendPatchRequestToEndpointWithPayload(String endpoint, Map<String, Object> payLoad){
        response = given()
                .accept(contentType)
                .and().contentType(contentType)
                .and().auth().basic(username,password)
                .and().body(payLoad)
                .when().patch(endpoint);
        return response;
    }

    public static int getLastCreatedSpartanId(){
        List<Integer> spartansIds = given()
                .accept(contentType)
                .and().contentType(contentType)
                .when().get()
                .jsonPath()
                .getList("id");
        return spartansIds.stream().mapToInt(Integer::intValue).max().orElse(-1);
    }

    public static Map<String, Object> createPayload(String name, String gender, String phone) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("phone", phone);
        return payload;
    }

    public static Map<String, Object> createPayload(String name) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", name);
        return payload;
    }

    public static String getActualData(String dataType){
        return switch (dataType) {
            case "status code" -> String.valueOf(response.statusCode());
            case "content type" -> response.contentType();
            case "name" -> response.path("data.name") == null ? response.path("name") : response.path("data.name");
            case "gender" ->
                    response.path("data.gender") == null ? response.path("gender") : response.path("data.gender");
            case "phone" ->
                    response.path("data.phone") == null ? response.path("phone").toString() : response.path("data.phone").toString();
            default -> null;
        };
    }

    public static List<String> getActualDataList(String dataType){
        return switch (dataType) {
            case "name" -> response.jsonPath().getList("content.name");
            case "gender" -> response.jsonPath().getList("content.gender");
            default -> null;
        };
    }

}
