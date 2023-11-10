package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String loginPageURL = "https://neo-mr.recruitcrm.io/v1/";
	public static final String email = "suryanshsingh03082001@gmail.com";
	public static final String password = "RCRMDEMO@rcrmdemo@2024";
	
	public static final String candidateFirstName = "Alan";
	public static final String candidateLastName = "Walker";
	
	public static final String companyName = "Stark Industries";
	public static final String industryType = "Manufacturing & Engineering";
	
	public static final String contactFirstName = "Jhon";
	public static final String contactLastName = "Snow";
	public static final List<String> companiesContactBelongTo = new ArrayList<>(Arrays.asList("Dunder Mifflin","Capsule Corporation"));
	
	public static final String pipeline = "Hiring Pipeline 1";
	public static final String jobTitle = "Automation Engineer";
	public static final String vacancy = "2";
	public static final String companyJobBelongTo = "Capsule Corporation";
	public static final String contactOfCompnay = "Bulma";
	
	public static final String browser = "Chrome";
	public static final String[][] customFields = {{"Field_1", "Text", ""},
			{"Field_2", "Long Text", ""},
			{"Field_3", "Date", ""},
			{"Field_4", "Number", ""},
			{"Field_5", "Checkbox", ""},
			{"Field_6", "Dropdown", "AWS, Azure, Google Cloud"},
			{"Field_7", "Multiselect", "SSD, GPU"},
			{"Field_8", "Phone Number", ""},
			{"Field_9", "Email Address", ""},
			{"Field_10", "File", ""}
			};

	public static final String[] deleteCustomFields = {"Field_1", 
			"Field_2",
			"Field_3",
			"Field_4",
			"Field_5",
			"Field_6",
			"Field_7",
			"Field_8",
			"Field_9",
			"Field_10"
			};
}
