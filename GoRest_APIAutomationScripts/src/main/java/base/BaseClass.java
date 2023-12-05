package base;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import utils.CreateURL;

public class BaseClass extends RequestManager {

	public ObjectMapper objectMapper = new ObjectMapper();

	public String requestModelToString(Object requestModel) throws JsonProcessingException {
		info("Initiate : Converting Request Body to a String Sequence...");
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String payLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestModel);
		info("Successfull : Converted Request Body to a String Sequence");
		return payLoad;
	}

	public String generateURI(String resourcePath) {
		info("Initiate : Generating URI");
		String uri = CreateURL.getBaseURI(resourcePath);
		info("Successfull : Generated URI = "+uri);
		return uri;
	}

	public String responseToString(Response response) {
		return response.getBody().asString();
	}

	public Object stringToResponseModel(Object object, String responseString, Class<?> className) throws JsonProcessingException {
		object = objectMapper.readValue(responseString, className);
		return object;
	}

}
