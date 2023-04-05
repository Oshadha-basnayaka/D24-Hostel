package lk.ijse.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @Column(name = "s_id", length = 50, nullable = false)
    private String id;
    @Column(name = "s_name", length = 50)
    private String name;
    @Column(name = "s_contact", length = 50)
    private int contact;
    @Column(name = "s_address", length = 50)
    private String address;
    @Column(name = "s_dob", length = 50)
    private Date dob;
    @Column(name = "s_gender", length = 50)
    private String gender;


}
