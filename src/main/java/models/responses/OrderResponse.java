package models.responses;

import lombok.Data;

import java.text.DateFormat;
import java.util.List;

@Data
public class OrderResponse {

    List<String> orders;

    Integer id;

    Integer courierId;

    String firstName;

    String lastName;

    String address;

    Integer metroStation;

    String phone;

    Integer rentTime;

    String deliveryDate;

    Integer track;

    List<String> color;

    String comment;

    DateFormat createdAt;

    DateFormat updatedAt;

    Integer status;

}
