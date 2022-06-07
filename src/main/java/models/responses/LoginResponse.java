package models.responses;

import lombok.Data;

@Data
public class LoginResponse {

    Integer id;

    public LoginResponse(Integer id) {
        this.id = id;
    }

}

