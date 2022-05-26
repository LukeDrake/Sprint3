package models.requests;

import lombok.Data;

@Data
public class DeleteCourierRequest {
    Integer id;

    public DeleteCourierRequest(Integer id) {
        this.id = id;
    }
}
