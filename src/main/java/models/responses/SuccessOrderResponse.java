package models.responses;

import lombok.Data;
@Data
public class SuccessOrderResponse {
    Integer track;

        public SuccessOrderResponse(Integer track) {
            this.track = track;
        }
    }


