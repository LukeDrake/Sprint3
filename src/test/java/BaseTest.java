import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.junit.BeforeClass;

public class BaseTest {
    @BeforeClass
    @Step("Инициализация базовых настроек тестов: имя хоста, тип http ответов и т.п.")
    public static void init(){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://qa-scooter.praktikum-services.ru")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }
}
