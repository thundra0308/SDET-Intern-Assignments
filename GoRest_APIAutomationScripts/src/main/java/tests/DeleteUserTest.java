package tests;

import api.application.User;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.DataLoader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUserTest_1() {
        String userId = DataLoader.getInstance().getDataProperty("user_id");
        Response response = User.delete(userId);
        verifyDeleteUserTest_1(response);
    }

    public void verifyDeleteUserTest_1(Response response) {
        assertThat(response.getStatusCode(), equalTo(204));
    }

}
