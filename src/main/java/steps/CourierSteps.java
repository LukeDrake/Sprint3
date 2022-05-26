package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.errors.ErrorCourier;
import models.requests.CreateCourierRequest;
import models.requests.LoginCourierRequest;
import models.responses.LoginResponse;
import models.responses.SuccessResponse;
import models.errors.ErrorLoginCourier;


import static io.restassured.RestAssured.given;

public class CourierSteps {
    @Step("Создаём курьера")
    public static SuccessResponse createCourier(CreateCourierRequest createCourierRequest){
       Response response = given()
               .body(createCourierRequest)
               .post("/api/v1/courier");
       response.then().statusCode(201);
       return  response.as(SuccessResponse.class);

    }

    @Step("Создаём курьера с ожидаемой ошибкой")
    public static ErrorCourier createCourierWithErrorExist(CreateCourierRequest createCourierRequest){
        Response response = given()
                .body(createCourierRequest)
                .post("/api/v1/courier");
        response.then().statusCode(409);
        return  response.as(ErrorCourier.class);
    }

    @Step("Создаём курьера с ожидаемой ошибкой")
    public static ErrorCourier createCourierWithError(CreateCourierRequest createCourierRequest){
        Response response = given()
                .body(createCourierRequest)
                .post("/api/v1/courier");
        response.then().statusCode(400);
        return  response.as(ErrorCourier.class);
    }

    @Step("Логинимся под определнным курьером")
    public static LoginResponse loginCourier(LoginCourierRequest loginCourierRequest){
        Response response = given()
                .body(loginCourierRequest)
                .post("/api/v1/courier/login");
        response.then().statusCode(200);
        return  response.as(LoginResponse.class);

    }


    @Step("Входим курьером с ожидаемой ошибкой - не существующего акка")
    public static ErrorLoginCourier loginCourierWithError(LoginCourierRequest loginCourierRequest){
        Response response = given()
                .body(loginCourierRequest)
                .post("/api/v1/courier/login");
        response.then().statusCode(404);
        return  response.as(ErrorLoginCourier.class);
    }

    @Step("Входим курьером с ожидаемой ошибкой - не хватает данных")
    public static ErrorLoginCourier loginCourierWithErrorNotEnough(LoginCourierRequest loginCourierRequest){
        Response response = given()
                .body(loginCourierRequest)
                .post("/api/v1/courier/login");
        response.then().statusCode(400);
        return  response.as(ErrorLoginCourier.class);
    }




    @Step("Удаляем курьера")
    public static SuccessResponse deleteCourier(Integer id){
        Response response = given()
                .delete("/api/v1/courier/"+id);
                 response.then().statusCode(200);
        return  response.as(SuccessResponse.class);
    }
}
