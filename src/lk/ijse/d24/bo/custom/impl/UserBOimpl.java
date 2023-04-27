package lk.ijse.d24.bo.custom.impl;

import lk.ijse.d24.bo.custom.UserBO;
import lk.ijse.d24.dao.DaoFactory;
import lk.ijse.d24.dao.DaoType;
import lk.ijse.d24.dao.custom.UserDAO;
import lk.ijse.d24.dto.UserDTO;
import lk.ijse.d24.entity.User;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserBOimpl implements UserBO {

    UserDAO userDAO =(UserDAO) DaoFactory.getInstance().getDAO(DaoType.USER);

    @Override
    public UserDTO getUser(String id) {
        User user = userDAO.search(id);
        return new UserDTO(
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getAddress(),
                user.getDateOfBirth()
        );
    }

    @Override
    public boolean addUser(UserDTO userDTO) {

        return userDAO.add(new User(
                userDTO.getName(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                userDTO.getAddress(),
                userDTO.getDateOfBirth()
        ));
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    @Override
    public ArrayList<UserDTO> getAllUser() {

        ArrayList<UserDTO> userList = new ArrayList<>();
        userList.addAll(userDAO.getAll().stream().map(user -> {
            return new UserDTO(
                    user.getName(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getDateOfBirth());
        }).collect(Collectors.toList()));

        return userList;
    }



}
