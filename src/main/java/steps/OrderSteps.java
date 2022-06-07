package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.requests.CreateOrderRequestBody;
import models.responses.OrderListResponse;
import models.responses.SuccessOrderResponse;
import util.RestAssuredClient;

import static config.ApiEndpoints.ORDER_ENDPOINT;
import static config.ConnectionSettings.BASE_URL;
import static io.restassured.RestAssured.given;

public class OrderSteps extends RestAssuredClient {
    public OrderSteps() {
        super(BASE_URL);
    }

    @Step("Создание заказа")
    public SuccessOrderResponse createOrder(CreateOrderRequestBody createOrderRequestBody, Integer code) {
        Response response = given()
                .body(createOrderRequestBody)
                .post(ORDER_ENDPOINT);
        response.then().statusCode(code);
        return response.as(SuccessOrderResponse.class);
    }

    @Step("Получение списка заказов")
    public OrderListResponse takeOrders(Integer code) {
        Response response = given()
               // .body(orderListResponse)
                .get(ORDER_ENDPOINT);
        response.then().statusCode(code);
        return response.as(OrderListResponse.class);
    }


    @Step("Удаляем курьера")
    public SuccessOrderResponse deleteOrder(Integer track, Integer code) {
        Response response = given()
                .put(ORDER_ENDPOINT + "cancel?track=" + track);
        response.then().statusCode(code);
        return response.as(SuccessOrderResponse.class);

    }
}
