package lk.ijse.d24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class RoomDTO {

    private String id;
    private String roomType;
    private String keyMoney;
    private int qty;
}
