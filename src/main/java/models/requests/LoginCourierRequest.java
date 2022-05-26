package models.requests;

import lombok.Data;

@Data
public class LoginCourierRequest {
    public static final LoginCourierRequest COURIER_TO_LOGIN = new LoginCourierRequest("vasyamba1","1234");

    public static final LoginCourierRequest COURIER_TO_LOGIN_ALT = new LoginCourierRequest("naruto1","1234");
    public static final LoginCourierRequest COURIER_TO_LOGIN_ERROR = new LoginCourierRequest("vasyamba1","");


    String login;
    String password;

    public LoginCourierRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
