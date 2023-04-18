package lk.ijse.d24.view.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserTM {

    private String name;
    private String password;
    private String email;
    private String address;
    private Date dateOfBirth;
}
