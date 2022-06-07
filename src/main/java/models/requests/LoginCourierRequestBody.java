package models.requests;

import lombok.Data;

@Data
public class LoginCourierRequestBody {
    public static final LoginCourierRequestBody COURIER_TO_LOGIN = new LoginCourierRequestBody("vasyamba1","1234");

    public static final LoginCourierRequestBody COURIER_TO_LOGIN_ALT = new LoginCourierRequestBody("naruto1","1234");
    public static final LoginCourierRequestBody COURIER_TO_LOGIN_ERROR = new LoginCourierRequestBody("vasyamba1","");


    String login;
    String password;

    public LoginCourierRequestBody(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
