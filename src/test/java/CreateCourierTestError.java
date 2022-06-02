import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.errors.ErrorCourier;
import models.requests.CreateCourierRequestBody;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import steps.CourierSteps;

@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Создание курьера - ошибки")

public class CreateCourierTestError {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Верная ошибка, если нехватает обязательных полей")
    public void createCourierWithOutLogin() {
        CourierSteps courierSteps = new CourierSteps();
        ErrorCourier response = courierSteps.createCourier(CreateCourierRequestBody.ERROR_COURIER_LOGIN,
                ErrorCourier.class,
                HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response, ErrorCourier.ERROR_NOT_ENOUGH_FIELDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Верная ошибка, если нехватает обязательных полей")
    public void createCourierWithOutPassword() {
        CourierSteps courierSteps = new CourierSteps();
        ErrorCourier response = courierSteps.createCourier(CreateCourierRequestBody.ERROR_COURIER_PASSWORD,
                ErrorCourier.class,
                HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response, ErrorCourier.ERROR_NOT_ENOUGH_FIELDS);
    }


}
