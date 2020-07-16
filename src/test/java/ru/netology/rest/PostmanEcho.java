package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEcho {
    @Test
    void shouldSendDataForEcho() {
        given()
                .baseUri("https://postman-echo.com")
                .body("User First")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("User First"));

    }

    @Test
    void shouldSendDataForEcho2() {
        given()
                .baseUri("https://postman-echo.com")
                .body("User Second")
                .header("Content-Type", "application/json")
                .when()
                .post("/post")
                .then()
                .statusCode(400)
                .body("data", equalTo("User Third"))
                .contentType(ContentType.JSON);
    }
}
