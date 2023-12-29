package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserModel {

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

}
