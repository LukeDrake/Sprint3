package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.requests.CreateOrderRequest;
import models.responses.OrderListResponse;
import models.responses.SuccessOrderResponse;

import static io.restassured.RestAssured.given;

public class OrderSteps {
    @Step("Создание заказа")
    public static SuccessOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        Response response = given()
                .body(createOrderRequest)
                .post("/api/v1/orders");
        response.then().statusCode(201);
        return response.as(SuccessOrderResponse.class);
    }

    @Step("Получение списка заказов")
    public static SuccessOrderResponse takeOrders(OrderListResponse orderListResponse) {
        Response response =  given()
                .body(orderListResponse)
                .get("/api/v1/orders");
        response.then().statusCode(200);
        return  response.as(SuccessOrderResponse.class);
    }


    @Step("Удаляем курьера")
    public static SuccessOrderResponse deleteOrder(Integer track) {
        Response response = given()
                .put("/api/v1/orders/cancel?track="+track);
        response.then().statusCode(200);
        return  response.as(SuccessOrderResponse.class);

    }
}
