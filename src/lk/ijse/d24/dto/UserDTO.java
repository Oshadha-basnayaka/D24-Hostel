package lk.ijse.d24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
    private String name;
    private String password;
    private String email;
    private String address;
    private Date dateOfBirth;

}
