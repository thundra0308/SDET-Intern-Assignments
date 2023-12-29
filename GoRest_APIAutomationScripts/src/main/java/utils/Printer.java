package utils;

import models.UserModel;
import static base.LoggerManager.*;

public class Printer {

    public static void print_userModel(UserModel userModel) {
        info("Id = "+userModel.getId());
        DataLoader.getInstance().setDataProperty("user_id",userModel.getId()+"");
        info("name = "+userModel.getName());
        info("Description = "+userModel.getEmail());
        info("Gender = "+userModel.getGender());
        info("Status = "+userModel.getStatus());
    }

}
