import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.requests.CreateOrderRequestBody;
import models.responses.OrderListResponse;
import models.responses.SuccessOrderResponse;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.OrderSteps;
import java.util.Arrays;



@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Проверка заказа заказа")

public class OrderGetTest {
    private Integer track;

    @Before
    public void setup() {
        OrderSteps orderSteps = new OrderSteps();
        CreateOrderRequestBody.NEW_ORDER.setColor(Arrays.asList("BLACK"));
        SuccessOrderResponse response = orderSteps.createOrder(CreateOrderRequestBody.NEW_ORDER,
                HttpStatus.SC_CREATED);
        this.track = response.getTrack();
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Заказ можно создать с разными цветами ")
    public void orderGetList() {
        OrderSteps orderSteps = new OrderSteps();
        OrderListResponse orderListResponse = orderSteps.takeOrders(
                HttpStatus.SC_OK);
        Assert.assertTrue(orderListResponse.getOrders().size() > 0);

    }

    @After
    public void teardown() {
        OrderSteps orderSteps = new OrderSteps();
        orderSteps.deleteOrder(this.track, HttpStatus.SC_OK);
    }

}
