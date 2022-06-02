package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.errors.ErrorCourier;
import models.requests.CreateCourierRequestBody;
import models.requests.LoginCourierRequestBody;
import models.responses.LoginResponse;
import models.responses.SuccessResponse;
import models.errors.ErrorLoginCourier;
import util.RestAssuredClient;


import static config.ApiEndpoints.COURIER_ENDPOINT;
import static config.ApiEndpoints.LOGIN_ENDPOINT;
import static config.ConnectionSettings.BASE_URL;
import static io.restassured.RestAssured.given;

public class CourierSteps extends RestAssuredClient {
    public CourierSteps() {
        super(BASE_URL);
    }

    @Step("Создаём курьера")
    public <T> T createCourier(CreateCourierRequestBody createCourierRequestBody, Class<T> clazz, Integer code) {
        Response response = given()
                .body(createCourierRequestBody)
                .post(COURIER_ENDPOINT);

        response.then().statusCode(code);

        if (SuccessResponse.class.equals(clazz)) {
            return clazz.cast(response.as(SuccessResponse.class));
        } else if (ErrorCourier.class.equals(clazz)) {
            return clazz.cast(response.as(ErrorCourier.class));
        }

        return null;
    }

    @Step("Логинимся под определённым курьером")
    public <T> T loginCourier(LoginCourierRequestBody loginCourierRequestBody, Class<T> clazz, Integer code) {
        Response response = given()
                .body(loginCourierRequestBody)
                .post(LOGIN_ENDPOINT);

        response.then().statusCode(code);

        if (LoginResponse.class.equals(clazz)) {
            return clazz.cast(response.as(LoginResponse.class));
        } else if (ErrorLoginCourier.class.equals(clazz)) {
            return clazz.cast(response.as(ErrorLoginCourier.class));
        }

        return null;

    }

    @Step("Удаляем курьера")
    public SuccessResponse deleteCourier(Integer id,  Integer code) {
        Response response = given()
                .delete(COURIER_ENDPOINT + id);
        response.then().statusCode(code);
        return response.as(SuccessResponse.class);
    }



}
