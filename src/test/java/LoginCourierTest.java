import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import models.errors.ErrorLoginCourier;
import models.requests.CreateCourierRequest;
import models.requests.LoginCourierRequest;
import models.responses.LoginResponse;
import models.responses.SuccessResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.CourierSteps;

@Feature("API учебного сервиса Яндекс.Самокат")
@Story("Логин курьера")
public class LoginCourierTest extends BaseTest{
    @Before
    public void prepare(){
        SuccessResponse response =  CourierSteps.createCourier(CreateCourierRequest.NEW_COURIER);
        Assert.assertEquals(response, SuccessResponse.OK_RESPONSE);
    }

    @After
    public void teardown(){
        Integer id = CourierSteps.loginCourier(LoginCourierRequest.COURIER_TO_LOGIN).getId();
        CourierSteps.deleteCourier(id);
    }

  @Test
  @Severity(SeverityLevel.NORMAL)
  @DisplayName("Можно войти под созданным курьером")
  public void loginCourierTest() {
  LoginResponse response = CourierSteps.loginCourier(LoginCourierRequest.COURIER_TO_LOGIN);
  Assert.assertTrue(Integer.class.isInstance(response.getId()));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Нельзя войти под несуществующим курьером")
    public void loginCourierWitNoNameOnTest() {
        ErrorLoginCourier response = CourierSteps.loginCourierWithError(LoginCourierRequest.COURIER_TO_LOGIN_ALT);
        Assert.assertEquals(response, ErrorLoginCourier.ERROR_NOEXIST_COURIER);

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Верная ошибка, если нехватает обязательных полей")
    public void loginCourierWithNotAllFields() {
        ErrorLoginCourier response = CourierSteps.loginCourierWithErrorNotEnough(LoginCourierRequest.COURIER_TO_LOGIN_ERROR);
        Assert.assertEquals(response, ErrorLoginCourier.ERROR_NOT_ENOUGH_FIELD);



    }
}
