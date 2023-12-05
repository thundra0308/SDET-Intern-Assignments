package userModel.createUser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserResponseModel {

	@JsonProperty("id")
	long id;

	@JsonProperty("name")
	String name;

	@JsonProperty("gender")
	String gender;

	@JsonProperty("email")
	String email;

	@JsonProperty("status")
	String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
