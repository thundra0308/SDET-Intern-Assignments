package utils;

import java.util.Properties;

import static utils.PropertyLoader.propertyLoader;

public class ConfigLoader {
    private final Properties prop;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        prop = propertyLoader(System.getProperty("user.dir") + "/src/main/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId(){
        String val = prop.getProperty("client_id");
        if(val != null) return val;
        else throw new RuntimeException("property client_id is not specified in the config.prop file");
    }

    public String getClientSecret(){
        String val = prop.getProperty("client_secret");
        if(val != null) return val;
        else throw new RuntimeException("property client_secret is not specified in the config.prop file");
    }

    public String getGrantType(){
        String val = prop.getProperty("grant_type");
        if(val != null) return val;
        else throw new RuntimeException("property grant_type is not specified in the config.prop file");
    }

    public String getRefreshToken(){
        String val = prop.getProperty("refresh_token");
        if(val != null) return val;
        else throw new RuntimeException("property refresh_token is not specified in the config.prop file");
    }

    public String getUser(){
        String val = prop.getProperty("user_id");
        if(val != null) return val;
        else throw new RuntimeException("property user_id is not specified in the config.prop file");
    }

}
