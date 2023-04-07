package lk.ijse.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    private Room room;

    @ManyToOne
    private Student student;



}
