package api;

import com.github.javafaker.Faker;
import models.UserModel;
import static base.LoggerManager.*;

public class FakerManager {

    public static Faker faker = new Faker();

    public static UserModel getFakeUserData() {
        info("<---- Initiated : Generating Fake Data for 'UserModel");
        UserModel userModel = UserModel.builder().
                name(faker.name().fullName()).
                email(faker.internet().emailAddress()).
                gender(faker.demographic().sex().toLowerCase()).
                status(faker.options().option("active", "inactive")).
                build();
        info("----> Successful : Generated Fake Data for 'UserModel");
        return userModel;
    }

}
