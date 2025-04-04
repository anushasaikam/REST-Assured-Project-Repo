package com.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class Delete {
     
    @Test
    public void testDELETE(){
                  
        JSONObject request = new JSONObject();
        request.put("name", "morphes");
        request.put("job", "zion resident");

            System.out.println(request.toJSONString());

            RestAssured.baseURI = "https://reqres.in/api";

            given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
            when().
                delete("/users/2").
            then().
                statusCode(204).and().
                log().all();
    }


}
