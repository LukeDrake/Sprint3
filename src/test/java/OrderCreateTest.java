import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.requests.CreateOrderRequest;
import models.responses.SuccessOrderResponse;
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
public class OrderCreateTest extends BaseTest{

    @Parameterized.Parameters(name = "{index}: colorset {0} ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { Arrays.asList("BLACK", "GREY")}, { Arrays.asList("BLACK") },  { Arrays.asList("GREY")}, { Arrays.asList("") }
        });
    }
    List<String> colors;

    public OrderCreateTest(List<String> colors) {
        this.colors=colors;
    }

    @After
    public void teardown(){
        Integer track = OrderSteps.createOrder(CreateOrderRequest.NEW_ORDER).getTrack();
        OrderSteps.deleteOrder(track);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
   @DisplayName("Заказ можно создать с разными цветами ")
   public void createOrderTest() {
        CreateOrderRequest.NEW_ORDER.setColor(colors);
        SuccessOrderResponse response = OrderSteps.createOrder(CreateOrderRequest.NEW_ORDER);
        Assert.assertNotNull(response.getTrack());
    }
}
