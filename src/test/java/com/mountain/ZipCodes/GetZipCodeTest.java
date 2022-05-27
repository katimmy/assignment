package com.mountain.ZipCodes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static  com.mountain.configs.ConfigurationManager.apiConfigurations;

import java.util.HashMap;
import java.util.Map;

import com.mountain.utils.AssertionUtil;
import com.mountain.utils.api.RestUtils;
import com.mountain.utils.api.jsonFormatter;
import com.mountain.zipcodes.GetZipCodeRequest;


public class GetZipCodeTest {

    GetZipCodeRequest getZipCodeRequest = new GetZipCodeRequest();
    RestUtils restUtils =  new RestUtils();
    AssertionUtil assertUtil = new AssertionUtil();
    jsonFormatter printJson = new jsonFormatter();

    @Test(description = "Retrieving all City Infomation by the ZipCode of Austin: Texas")
    public void retrievCityInfo(){
     String endpoint,service,json;
     SoftAssert sa;

     endpoint = apiConfigurations().zipcodeEndpoint();
     service = apiConfigurations().zipcodeServiceUrl();
     Map<String , String> placeData = new HashMap<String , String>();
     
     String zipcode = "78737";

     json = getZipCodeRequest.GetCityInfo(zipcode);

     Response response = restUtils.getGetResponse(json, service, endpoint);

     JsonPath locationData = response.jsonPath();

   
     printJson.printWellFormatedJson(response.asString(), "response", service);

     sa = assertUtil.assertEquals("Status", String.valueOf(response.statusCode()), "200", "Call Returned Bad Response");
     sa = assertUtil.assertEquals("Postal Zip Code", locationData.getString("'post code'"), zipcode, "Wrong ZipCode Returned");
     sa = assertUtil.assertEquals("Country", locationData.getString("country"), "United States", "Wrong Country Returned");
     sa = assertUtil.assertEquals("country abbreviation", locationData.getString("'country abbreviation'"), "US", "Wrong Country Returned");
     sa = assertUtil.assertEquals("place name", locationData.getString("places[0].state"), "Texas", "Wrong State Name Returned");
     sa = assertUtil.assertEquals("state abbreviation", locationData.getString("places[0].'state abbreviation'"), "TX", "Wrong State Abbreviations Returned");
     
     sa.assertAll();
     

        
    }
    
}
