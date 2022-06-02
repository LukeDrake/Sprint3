import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.errors.ErrorLoginCourier;
import models.requests.CreateCourierRequestBody;
import models.requests.LoginCourierRequestBody;
import models.responses.LoginResponse;
import models.responses.SuccessResponse;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Логин курьера")
public class LoginCourierTest {
    @Before
    public void setup() {
        CourierSteps courierSteps = new CourierSteps();
        SuccessResponse response = courierSteps.createCourier(CreateCourierRequestBody.NEW_COURIER,
                SuccessResponse.class,
                HttpStatus.SC_CREATED);
        Assert.assertEquals(response, SuccessResponse.OK_RESPONSE);
    }

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
    @DisplayName("Можно войти под созданным курьером")
    public void loginCourierTest() {
        CourierSteps courierSteps = new CourierSteps();
        LoginResponse response = courierSteps.loginCourier(LoginCourierRequestBody.COURIER_TO_LOGIN,
                LoginResponse.class,
                HttpStatus.SC_OK);
        Assert.assertTrue(Integer.class.isInstance(response.getId()));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Нельзя войти под несуществующим курьером")
    public void loginCourierWitNoNameOnTest() {
        CourierSteps courierSteps = new CourierSteps();
        ErrorLoginCourier response = courierSteps.loginCourier(LoginCourierRequestBody.COURIER_TO_LOGIN_ALT,
                ErrorLoginCourier.class,
                HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(response, ErrorLoginCourier.ERROR_NOEXIST_COURIER);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Верная ошибка, если нехватает обязательных полей")
    public void loginCourierWithNotAllFields() {
        CourierSteps courierSteps = new CourierSteps();
        ErrorLoginCourier response = courierSteps.loginCourier(LoginCourierRequestBody.COURIER_TO_LOGIN_ERROR,
                ErrorLoginCourier.class,
                HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response, ErrorLoginCourier.ERROR_NOT_ENOUGH_FIELD);


    }
}
