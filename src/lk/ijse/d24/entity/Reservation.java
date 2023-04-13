package lk.ijse.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Reservation {
@Id
@Column(name = "res_id", length = 50, nullable = false)
    private String id;
    @Column(name = "res_date", length = 50)
    private Date date;
    @Column(name = "res_status", length = 50)
    private String status;
    @Column(name = "res_student_id", length = 50)
//    private String reservationStudentId;
//    @Column(name = "res_room_id", length = 50)
//    private String reservationRoomId;

    @ManyToOne
    @JoinColumn(name = "s_id",referencedColumnName = "s_id",nullable = false)
    private Room room;

    @JoinColumn(name = "r_id" , referencedColumnName = "r_id",nullable = false)
    @ManyToOne
    private Student student;



}
