package com.accelerator.spring.automationaccelerator.mouri;

import com.accelerator.spring.automationaccelerator.mouri.annotations.LazyApiAutowired;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@LazyApiAutowired
public class RestApiSpecification {

    public RequestSpecification getHttpRequest(String uri){
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured.given();
        return httpRequest;
    }
}
