package tests;

import api.FakerManager;
import api.application.User;
import base.BaseTest;
import io.restassured.response.Response;
import models.UserModel;
import org.testng.annotations.Test;
import utils.DataLoader;
import utils.Printer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUserTest_1() {
        String userId = DataLoader.getInstance().getDataProperty("user_id");
        UserModel requestModel = FakerManager.getFakeUserData();
        Response response = User.put(userId, requestModel);
        UserModel responseModel = response.as(UserModel.class);
        verifyUpdateUserTest_1(response, requestModel, responseModel);
        Printer.print_userModel(responseModel);
    }

    public void verifyUpdateUserTest_1(Response response, UserModel requestModel, UserModel responseModel) {
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(responseModel.getName(), equalTo(requestModel.getName()));
        assertThat(responseModel.getEmail(), equalTo(requestModel.getEmail()));
        assertThat(responseModel.getGender(), equalTo(requestModel.getGender()));
        assertThat(responseModel.getStatus(), equalTo(requestModel.getStatus()));
    }

}
