package lk.ijse.d24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity


public class ReservationDTO {

    private String id;
    private Date date;
    private String status;
    private String reservationStudentId;
    private String reservationRoomId;

}
