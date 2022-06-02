package models.responses;
import lombok.Data;

import java.util.ArrayList;


@Data
public class OrderListResponse {

    ArrayList<OrderResponse> orders;
}
