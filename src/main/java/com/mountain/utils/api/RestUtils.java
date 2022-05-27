package com.mountain.utils.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

    public Response getGetResponse(Object json , String service , String endpoint){
     
        RestAssured.baseURI = service;

        String serviceURL = endpoint + json;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, serviceURL);
        return response;
        

    }
    
}
