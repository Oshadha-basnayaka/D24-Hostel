package lk.ijse.d24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data



public class ReservationDTO {

    private String id;
    private Date date;
    private String status;
    private String StudentId;
    private String RoomId;

}
