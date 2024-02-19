package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jsoup.Connection;

import java.util.Map;

public class APIUtils {

    public static Response sendPostRequest(RequestSpecification request, String endpoint) {
        return RestAssured.given()
                .spec(request)
                .when()
                .post(endpoint);
    }

    public static Response sendPostRequest(RequestSpecification request, String endpoint, Object body) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .post(endpoint);
    }

    public static Response sendPostRequest(RequestSpecification request, String endpoint, Map<String, String> queryParam, Object body) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .body(body).log().all()
                .queryParams(queryParam)
                .when()
                .post(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint) {
        return RestAssured.given()
                .spec(request)
                .when()
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, Object body) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, Map<String, String> queryParam) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .log().all()
                .queryParams(queryParam)
                .when()
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, Integer pathParam) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .when().log().all()
                .get(endpoint + "/" + pathParam);
    }

    public static Response sendDeleteRequest(RequestSpecification request,String endpoint,String token,Integer pathParam){
        return RestAssured.given().spec(request)
                .header("Cookie","token="+token)
                .when()
                .delete(endpoint+"/"+pathParam);
    }

    public static Response sendPutRequest(RequestSpecification request,String endpoint,String token,Integer pathParam,String body){
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie","token="+token)
                .body(body)
                .when()
                .put(endpoint+"/"+pathParam);
    }
}
