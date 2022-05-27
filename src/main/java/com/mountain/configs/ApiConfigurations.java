package com.mountain.configs;
import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties","classpath:apis.properties"})
public interface ApiConfigurations extends Config {

 @Key("zipcode.serviceurl")
 String zipcodeServiceUrl();

 @Key("zipcode.endpoint")
 String zipcodeEndpoint();
    
}
