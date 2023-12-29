package tests;

import api.application.User;
import base.BaseTest;
import io.restassured.response.Response;
import models.UserModel;
import org.testng.annotations.Test;
import utils.DataLoader;
import utils.Printer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTest extends BaseTest {

    @Test
    public void getUserTest_1() {
        String userId = DataLoader.getInstance().getDataProperty("user_id");
        Response response = User.get(userId);
        UserModel responseModel = response.as(UserModel.class);
        verifyGetUserTest_1(response);
        Printer.print_userModel(responseModel);
    }

    public void verifyGetUserTest_1(Response response) {
        assertThat(response.getStatusCode(), equalTo(200));
    }

}
