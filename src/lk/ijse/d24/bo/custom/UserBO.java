package lk.ijse.d24.bo.custom;

import lk.ijse.d24.bo.SuperBO;
import lk.ijse.d24.dto.UserDTO;

import java.util.ArrayList;

public interface  UserBO extends SuperBO {



    UserDTO getUser(String id);

    public  boolean addUser(UserDTO userDTO);
    public boolean updateUser(UserDTO userDTO);
    public boolean deleteUser(String id);

    ArrayList<UserDTO> getAllUser();

}
