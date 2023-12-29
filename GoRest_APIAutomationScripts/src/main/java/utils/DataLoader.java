package utils;

import java.util.Properties;

import static utils.PropertyLoader.*;

public class DataLoader {

    private final Properties prop;
    private static DataLoader dataLoader;

    private DataLoader() {
        prop = propertyLoader(System.getProperty("user.dir") + "/src/main/resources/data.properties");
    }

    public static DataLoader getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getDataProperty(String key) {
        String value = prop.getProperty(key);
        if(value != null) return value;
        else throw new RuntimeException("Property "+key+" is not specified in the -> 'data.properties' : File");
    }

    public void setDataProperty(String key, String value) {
        prop.setProperty(key, value);
        saveProperties("Data Store", System.getProperty("user.dir")+"/src/main/resources/data.properties");
    }

}
