import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.errors.ErrorCourier;
import models.requests.CreateCourierRequest;
import org.junit.Assert;
import org.junit.Test;
import steps.CourierSteps;
@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Создание курьера - ошибки")

public class CreateCourierTestError extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Верная ошибка, если нехватает обязательных полей")
    public void createCourierWithNotAllFields() {
        ErrorCourier response = CourierSteps.createCourierWithError(CreateCourierRequest.ERROR_COURIER);
        Assert.assertEquals(response, ErrorCourier.ERROR_NOT_ENOUGH_FIELDS);
    }


}
