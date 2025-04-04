package com.restassured;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Get {
    @Test
        public void testGet(){
            RestAssured.baseURI = "https://reqres.in/";
            given().
                get("/api/users?page=2")
            .then()
                .statusCode(200).
                body("data[1].first_name", equalTo("Lindsay")).
                log().all();

        }

}
