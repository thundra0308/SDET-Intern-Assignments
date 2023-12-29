package api.application;

import api.PathBuilder;
import api.RequestManager;
import io.restassured.response.Response;
import models.UserModel;
import static api.TokenManager.*;

public class User {

    public static Response get(String userId) {
        return RequestManager.get(PathBuilder.USERS_PATH + userId, getBearerToken());
    }

    public static Response post(UserModel userModel) {
        return RequestManager.post(PathBuilder.USERS_PATH, getBearerToken(), userModel);
    }

    public static Response put(String userId, UserModel userModel) {
        return RequestManager.put(PathBuilder.USERS_PATH + userId, getBearerToken(), userModel);
    }

    public static Response delete(String userId) {
        return RequestManager.delete(PathBuilder.USERS_PATH + userId, getBearerToken());
    }

}
