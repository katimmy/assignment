package com.mountain.configs;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    private ConfigurationManager(){}

    public static ApiConfigurations apiConfigurations() {

        return  ConfigCache.getOrCreate(ApiConfigurations.class);
    
    }
    
}
