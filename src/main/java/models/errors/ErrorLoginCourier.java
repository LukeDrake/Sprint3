package models.errors;

import lombok.Data;

@Data
public class ErrorLoginCourier {

    public static final ErrorLoginCourier ERROR_NOEXIST_COURIER = new ErrorLoginCourier(404 ,"Учетная запись не найдена");
    public static final ErrorLoginCourier ERROR_NOT_ENOUGH_FIELD = new ErrorLoginCourier(400,"Недостаточно данных для входа");

    Integer code;
    String message;

    public ErrorLoginCourier(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
