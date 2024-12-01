package utils;

import config.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    private static final String BASE_URL = "https://api.trello.com/1";

    // GET Method
    public static Response get(String endpoint) {
        return RestAssured
                .given()
                .queryParam("key", ConfigLoader.get("api.key"))
                .queryParam("token", ConfigLoader.get("api.token"))
                .get(BASE_URL + endpoint);
    }

    // POST Method
    public static Response post(String endpoint, String body) {
        return RestAssured
                .given()
                .queryParam("key", ConfigLoader.get("api.key"))
                .queryParam("token", ConfigLoader.get("api.token"))
                .header("Content-Type", "application/json")
                .body(body)
                .post(BASE_URL + endpoint);
    }

    // PUT Method
    public static Response put(String endpoint, String body) {
        return RestAssured
                .given()
                .queryParam("key", ConfigLoader.get("api.key"))
                .queryParam("token", ConfigLoader.get("api.token"))
                .header("Content-Type", "application/json")
                .body(body)
                .put(BASE_URL + endpoint);
    }

    // DELETE Method
    public static Response delete(String endpoint) {
        return RestAssured
                .given()
                .queryParam("key", ConfigLoader.get("api.key"))
                .queryParam("token", ConfigLoader.get("api.token"))
                .delete(BASE_URL + endpoint);
    }
}
