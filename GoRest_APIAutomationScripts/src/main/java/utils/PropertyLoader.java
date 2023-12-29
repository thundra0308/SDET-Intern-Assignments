package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static Properties properties = new Properties();

    public static Properties propertyLoader(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void saveProperties(String fileDesc, String filePath) {
        try (FileOutputStream file = new FileOutputStream(filePath)) {
            properties.store(file, "Data Store");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
