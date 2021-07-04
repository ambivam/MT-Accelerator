package com.accelerator.spring.automationaccelerator.mouri;


import com.accelerator.spring.automationaccelerator.mouri.annotations.LazyApiAutowired;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@LazyApiAutowired
public class RestApi {

    private Response response;

    @Autowired
    private RestApiSpecification restApiSpecification;

    public void get(String uri,String endPoint){
       this.response = restApiSpecification.getHttpRequest(uri).request(Method.GET,"/"+endPoint);
    }

    public void post(String uri,String path,String endPoint) throws IOException, ParseException {
        RequestSpecification requestSpecification = restApiSpecification.getHttpRequest(uri);
        Object obj = new JSONParser().parse(new FileReader(path));
        JSONObject jsonObject = (JSONObject) obj;
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(jsonObject.toJSONString());
        System.out.println("The json string is : "+ jsonObject.toJSONString());
        this.response = requestSpecification.request(Method.POST,"/"+endPoint);
    }

    public String getBody(){
        return response.getBody().asString();
    }

    public int getStatusCode(){
        return response.getStatusCode();
    }

    public String getStatusLine(){
        return response.getStatusLine();
    }

    public String getContent(String key){
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.get(key);
    }

    public List<Header> getHeadersList(){
        Headers headers = response.getHeaders();
        return headers.asList();
    }

}
