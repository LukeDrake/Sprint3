package models.requests;

import lombok.Data;

@Data
public class CreateCourierRequest {
    public static final CreateCourierRequest NEW_COURIER = new CreateCourierRequest("vasyamba1","1234","naruto");
    public static final CreateCourierRequest ERROR_COURIER = new CreateCourierRequest(null,"1234","naruto");

    String login;
    String password;
    String firstName;

    public CreateCourierRequest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;

    }
}

