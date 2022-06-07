package models.requests;

import lombok.Data;

@Data
public class DeleteCourierRequestBody {
    Integer id;

    public DeleteCourierRequestBody(Integer id) {
        this.id = id;
    }
}
