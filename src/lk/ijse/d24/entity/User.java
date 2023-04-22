package lk.ijse.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class User {
    @Id
    @Column(name = "u_name", length = 10)
    private String name;
    @Column(name = "pass_word", length = 8, nullable = false)
    private String password;
    @Column(name = "e_mail", length = 25, nullable = false)
    private String email;
    @Column(name = "address", length = 50, nullable = false)
    private String address;
    @Column(name = "dob", length = 8, nullable = false)
    private Date dateOfBirth;


}
