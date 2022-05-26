package models.errors;

import lombok.Data;

@Data
public class ErrorCourier {
    public static final ErrorCourier ERROR_EXIST_COURIER = new ErrorCourier(409,"Этот логин уже используется. Попробуйте другой.");
    public static final ErrorCourier ERROR_NOT_ENOUGH_FIELDS = new ErrorCourier(400,"Недостаточно данных для создания учетной записи");

    Integer code;
    String message;

    public ErrorCourier(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
