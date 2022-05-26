package models.requests;
import org.junit.runners.Parameterized;
import lombok.Data;
import java.util.Arrays;
import java.util.List;

@Data
public class CreateOrderRequest {


    public static CreateOrderRequest NEW_ORDER = new CreateOrderRequest("Naruto","Uchiha","Konoha, 142 apt.", 4, "+7 800 355 35 35",
            5, "2020-06-06", "Saske, come back to Konoha",null);

    public static final CreateOrderRequest NEW_ORDER_ONE_COLOR = new CreateOrderRequest("Naruto","Uchiha","Konoha, 142 apt.", 4, "+7 800 355 35 35",
            5, "2020-06-06", "Saske, come back to Konoha", Arrays.asList("BLACK"));

    public static final CreateOrderRequest NEW_ORDER_NO_COLORS = new CreateOrderRequest("Naruto","Uchiha","Konoha, 142 apt.", 4, "+7 800 355 35 35",
            5, "2020-06-06", "Saske, come back to Konoha", Arrays.asList());


    String firstName;

    String lastName;

    String address;

    Integer metroStation;

    String phone;

    Integer rentTime;

    String deliveryDate;

    String comment;

    List<String> color;


    public CreateOrderRequest(String firstName, String lastName, String address, Integer metroStation, String phone, Integer rentTime, String deliveryDate,
                                String comment, List<String> color) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.address = address;
         this.metroStation = metroStation;
         this.phone = phone;
         this.rentTime = rentTime;
         this.deliveryDate = deliveryDate;
         this.comment = comment;
         this.color = color;
    }
}
