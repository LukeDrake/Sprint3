import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.requests.CreateOrderRequestBody;
import models.responses.SuccessOrderResponse;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderSteps;

import java.util.Arrays;
import java.util.List;


@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Создание заказа")
@RunWith(Parameterized.class)
public class OrderCreateTest {

    @Parameterized.Parameters(name = "{index}: colorset {0} ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("BLACK", "GREY")}, {Arrays.asList("BLACK")}, {Arrays.asList("GREY")}, {Arrays.asList()}
        });
    }

    List<String> colors;

    public OrderCreateTest(List<String> colors) {
        this.colors = colors;
    }

    @After
    public void teardown() {
        OrderSteps orderSteps = new OrderSteps();
        Integer track = orderSteps.createOrder(CreateOrderRequestBody.NEW_ORDER,
                HttpStatus.SC_CREATED).getTrack();
        orderSteps.deleteOrder(track, HttpStatus.SC_OK);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Заказ можно создать с разными цветами ")
    public void createOrderTest() {
        OrderSteps orderSteps = new OrderSteps();
        CreateOrderRequestBody.NEW_ORDER.setColor(colors);
        SuccessOrderResponse response = orderSteps.createOrder(CreateOrderRequestBody.NEW_ORDER,
                HttpStatus.SC_CREATED);
        Assert.assertNotNull(response.getTrack());
    }
}
