package models.responses;

import lombok.Data;

@Data
public class SuccessResponse {
    public static final SuccessResponse OK_RESPONSE = new SuccessResponse(true);

    boolean ok;

    public SuccessResponse(boolean ok) {
        this.ok = ok;
    }
}
