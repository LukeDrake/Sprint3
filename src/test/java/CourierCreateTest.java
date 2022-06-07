import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.errors.ErrorCourier;
import models.requests.CreateCourierRequestBody;
import models.requests.LoginCourierRequestBody;
import models.responses.LoginResponse;
import models.responses.SuccessResponse;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import steps.CourierSteps;

@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Создание курьера")
public class CourierCreateTest {
    @After
    public void teardown() {
        CourierSteps courierSteps = new CourierSteps();
        Integer id = courierSteps.loginCourier(LoginCourierRequestBody.COURIER_TO_LOGIN,
                LoginResponse.class,
                HttpStatus.SC_OK).getId();
        courierSteps.deleteCourier(id, HttpStatus.SC_OK);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Курьера можно создать")
    public void createCourierTest() {
        CourierSteps courierSteps = new CourierSteps();
        SuccessResponse response = courierSteps.createCourier(CreateCourierRequestBody.NEW_COURIER,
                SuccessResponse.class,
                HttpStatus.SC_CREATED);
        Assert.assertEquals(response, SuccessResponse.OK_RESPONSE);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Нельзя создать двух одинаковых курьеров")
    public void createCourierWithSameNameTest() {
        CourierSteps courierSteps = new CourierSteps();
        courierSteps.createCourier(CreateCourierRequestBody.NEW_COURIER,
                SuccessResponse.class,
                HttpStatus.SC_CREATED);
        ErrorCourier errorExistCourier = courierSteps.createCourier(CreateCourierRequestBody.NEW_COURIER,
                ErrorCourier.class,
                HttpStatus.SC_CONFLICT);
        Assert.assertEquals(errorExistCourier, ErrorCourier.ERROR_EXIST_COURIER);

    }


}
