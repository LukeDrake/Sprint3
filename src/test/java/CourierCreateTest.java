import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.errors.ErrorCourier;
import models.requests.CreateCourierRequest;
import models.requests.LoginCourierRequest;
import models.responses.SuccessResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import steps.CourierSteps;

@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Создание курьера")
public class CourierCreateTest extends BaseTest{
    @After
    public void teardown(){
        Integer id = CourierSteps.loginCourier(LoginCourierRequest.COURIER_TO_LOGIN).getId();
        CourierSteps.deleteCourier(id);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Курьера можно создать")
    public void createCourierTest() {
        SuccessResponse response = CourierSteps.createCourier(CreateCourierRequest.NEW_COURIER);
        Assert.assertEquals(response, SuccessResponse.OK_RESPONSE);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Нельзя создать двух одинаковых курьеров")
    public void createCourierWithSameNameTest() {
        CourierSteps.createCourier(CreateCourierRequest.NEW_COURIER);
        ErrorCourier errorExistCourier = CourierSteps.createCourierWithErrorExist(CreateCourierRequest.NEW_COURIER);
        Assert.assertEquals(errorExistCourier, ErrorCourier.ERROR_EXIST_COURIER);

    }


}
