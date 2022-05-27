package com.mountain.utils;


import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionUtil {

    SoftAssert softAssert = new SoftAssert();
  

    public SoftAssert assertEquals(String fieldNameAsserted, Object actual , Object expected , String message){

        try {

            Assert.assertEquals(actual, expected,message);
            System.out.println("Verified that the "+ fieldNameAsserted + " " + expected + " is returned");
            
        } catch (AssertionError | Exception e) {
           
            softAssert.assertEquals(actual, expected,message);
        }
        return softAssert;


    }
    
}
