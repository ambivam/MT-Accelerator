package com.accelerator.spring.automationaccelerator.restapitest;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.mouri.RestApi;
import io.restassured.http.Header;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.io.IOException;


public class ApiTest extends SpringBaseTestNGTest {

    @Autowired
    private RestApi restApi;

    @Value("${baseURI}")
    private String uri;

    @Value("${endpoint}")
    private String endPoint;

    @Value("${baseCustomerURI}")
    private String customerEndPoint;

    @Value("${restapi.jsonfile}")
    private String jsonPath;

    @Value("${endpointregister}")
    private String register;

    @Value("${typocodeuri}")
    private String typocodeuri;

    @Value("${restapi.jsonfile.typocode}")
    private String jsonTypoCodePath;

    @Value("${endpointtypo}")
    private String endpointtypo;


    @Test
    void getWeatherDetails() throws IOException, ParseException {
        System.out.println("Ha ha ha 0"+jsonPath);
        //restApi.get(uri,endPoint);
        restApi.post(typocodeuri,jsonTypoCodePath,endpointtypo);
        System.out.println("Ha ha ha post post"+restApi.getBody());
        System.out.println("Ha ha ha 2 post"+restApi.getStatusCode());
        System.out.println("Ha ha ha 3 post"+restApi.getStatusLine());
        System.out.println("The content is post : "+ restApi.getContent("title"));
        System.out.println("************************************");
        restApi.get(typocodeuri,endpointtypo);
        System.out.println("Ha ha ha get "+restApi.getBody());
        System.out.println("Ha ha ha 2 get"+restApi.getStatusCode());
        System.out.println("Ha ha ha 3 get"+restApi.getStatusLine());
        for(Header header : restApi.getHeadersList()){
            System.out.println("The hedaers name is : "+ header.getName() + " Value are : "+ header.getValue());
        }

    }
}
