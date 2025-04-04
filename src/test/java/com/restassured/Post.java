package com.restassured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class Post {
    @Test
    public void post(){
     
          JSONObject request = new JSONObject();
            request.put("name", "morphes");
            request.put("job", "leader");

            System.out.println(request.toJSONString());

            RestAssured.baseURI = "https://reqres.in/api";

            given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
            when().
                post("/users").
            then().
                statusCode(201).and().
                log().all();

    }

}
