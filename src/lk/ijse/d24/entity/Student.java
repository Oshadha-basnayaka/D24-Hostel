package lk.ijse.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Student(String id, String name, String address, int contact, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }


}
