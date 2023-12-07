package base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import utils.CreateURL;

public class BaseClass extends RequestManager {

	public ObjectMapper objectMapper;
	public static Properties prop;
	
	// Initialize ObjectMapper and Property File
	public BaseClass() {
		this.objectMapper = new ObjectMapper();
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/utils/GlobalVariables.properties");
			prop.load(file);
		} catch (Exception e) {
			error(e.getMessage());
		}
		
	}

	// Serialization of POJO Model to String
	public String requestModelToString(Object requestModel) throws JsonProcessingException {
		info("Initiate : Converting Request Body to a String Sequence...");
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String payLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestModel);
		info("Successfull : Converted Request Body to a String Sequence");
		return payLoad;
	}

	// Generates Full URI using Base URL and Resource Path
	public String generateURI(String resourcePath) {
		info("Initiate : Generating URI");
		String uri = CreateURL.getBaseURI(resourcePath);
		info("Successfull : Generated URI = "+uri);
		return uri;
	}

	// Converts Response to String
	public String responseToString(Response response) {
		return response.getBody().asString();
	}

	// De-Serialization of Response String to POJO Model
	public Object stringToResponseModel(Object object, String responseString, Class<?> className) throws JsonProcessingException {
		object = objectMapper.readValue(responseString, className);
		return object;
	}
	
	// Set a Property
	public void setProperty(String key, String value) {
		prop.setProperty(key, value);
		saveProperties();
	}
	
	// Get a Property
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	// Save Set Properties
	public void saveProperties() {
		try (FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/utils/GlobalVariables.properties")) {
            prop.store(fos, "Global Variables");
        } catch (IOException e) {
            error(e.getMessage());
        }
	}

}
