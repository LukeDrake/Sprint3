package models.requests;
import lombok.Data;
import java.util.Arrays;
import java.util.List;

@Data
public class CreateOrderRequestBody {


    public static CreateOrderRequestBody NEW_ORDER = new CreateOrderRequestBody("Naruto","Uchiha","Konoha, 142 apt.", 4, "+7 800 355 35 35",
            5, "2020-06-06", "Saske, come back to Konoha",null);

    public static final CreateOrderRequestBody NEW_ORDER_ONE_COLOR = new CreateOrderRequestBody("Naruto","Uchiha","Konoha, 142 apt.", 4, "+7 800 355 35 35",
            5, "2020-06-06", "Saske, come back to Konoha", Arrays.asList("BLACK"));

    public static final CreateOrderRequestBody NEW_ORDER_NO_COLORS = new CreateOrderRequestBody("Naruto","Uchiha","Konoha, 142 apt.", 4, "+7 800 355 35 35",
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


    public CreateOrderRequestBody(String firstName, String lastName, String address, Integer metroStation, String phone, Integer rentTime, String deliveryDate,
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
