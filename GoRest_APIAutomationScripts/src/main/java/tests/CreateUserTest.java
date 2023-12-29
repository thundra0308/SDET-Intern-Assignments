package tests;

import api.FakerManager;
import api.application.User;
import base.BaseTest;
import io.restassured.response.Response;
import models.UserModel;
import org.testng.annotations.Test;
import utils.Printer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUserTest_1() {
        UserModel requestModel = FakerManager.getFakeUserData();
        Response response = User.post(requestModel);
        UserModel responseModel = response.as(UserModel.class);
        verifyCreateUserTest_1(response, requestModel, responseModel);
        Printer.print_userModel(responseModel);
    }

    public void verifyCreateUserTest_1(Response response, UserModel requestModel, UserModel responseModel) {
        assertThat(response.getStatusCode(), equalTo(201));
        assertThat(responseModel.getName(), equalTo(requestModel.getName()));
        assertThat(responseModel.getEmail(), equalTo(requestModel.getEmail()));
        assertThat(responseModel.getGender(), equalTo(requestModel.getGender()));
        assertThat(responseModel.getStatus(), equalTo(requestModel.getStatus()));
    }

}
