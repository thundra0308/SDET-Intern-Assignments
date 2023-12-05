package utils;

public class CreateURL {

	public final static String baseURI = "https://gorest.co.in/public/v2";

	public static String getBaseURI() {
		return baseURI;
	}

	public static String getBaseURI(String resource) {
		return baseURI + resource;
	}
}
