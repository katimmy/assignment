package com.mountain.utils.api;

import com.fasterxml.jackson.databind.ObjectMapper;



public class jsonFormatter {

   public String prettyJson , json;
   
   public String printWellFormatedJson(String json, String calltype, String servicename){
 
     ObjectMapper mapper = new ObjectMapper();
     try{

        Object jsonObject = mapper.readValue(json, Object.class);
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        if(calltype.equalsIgnoreCase("request")){
           System.out.println(" The "+ calltype+ " sent to service "+ servicename);

        }else{

            System.out.println(" The "+ calltype+ " recieved from service "+ servicename);  
        }

        System.out.println(prettyJson);

     }catch(Exception e){
      
        e.printStackTrace();

     }

    return prettyJson;
       

    
   }
    
}
