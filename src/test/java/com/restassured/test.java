package com.restassured;

import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class test {

@Test
    public void methodOne(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(("Status Code of the response is: " +response.getStatusCode()));
        
    }

@Test
    public void methodTwo(){

        RestAssured.baseURI = "https://reqres.in/api";
         
        given().
            get("/users?page=2").
         then().
            statusCode(200).
            body("data[1].id", equalTo(8)).
            log().all();
       
        
    }

    
}
