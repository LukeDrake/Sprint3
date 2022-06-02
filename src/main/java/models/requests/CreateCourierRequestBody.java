package models.requests;

import lombok.Data;

@Data
public class CreateCourierRequestBody {
    public static final CreateCourierRequestBody NEW_COURIER = new CreateCourierRequestBody("vasyamba1","1234","naruto");
    public static final CreateCourierRequestBody ERROR_COURIER_LOGIN = new CreateCourierRequestBody(null,"1234","naruto");
    public static final CreateCourierRequestBody ERROR_COURIER_PASSWORD = new CreateCourierRequestBody("vasyamba1",null,"naruto");

    String login;
    String password;
    String firstName;

    public CreateCourierRequestBody(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;

    }
}

