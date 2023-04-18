package lk.ijse.d24.view.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ReservationTM {
    private String id;
    private Date date;
    private String status;
    private String StudentId;
    private String RoomId;
}
