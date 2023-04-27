package lk.ijse.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.bo.BoFactory;
import lk.ijse.d24.bo.BoType;
import lk.ijse.d24.bo.custom.UserBO;
import lk.ijse.d24.dto.UserDTO;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;
import lk.ijse.d24.util.Validation;

import java.io.IOException;
import java.sql.Date;

public class UserFormContoller {
    public AnchorPane pane;
    public TextField txtUserName;
    public TextField txtUserEmail;
    public TextField txtUserAddress;
    public TextField txtUserDOB;
    public TextField txtUserPassword;
    

    UserBO userBO = (UserBO) BoFactory.getInstance().getBO(BoType.USER);

    public void onActionBtnReservation(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.RESERVATION, pane);
    }

    public void onActionBtnStudent(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENT, pane);
    }

    public void onActionBtnRoom(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ROOM, pane);
    }

    public void onActionBtnUser(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USER, pane);
    }

    public void onActionBtnSignOut(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void onActionBtnUserAdd(ActionEvent actionEvent) {

        String userName = txtUserName.getText();
        String passWord = txtUserPassword.getText();
        String userEmail = txtUserEmail.getText();
        String userAddress = txtUserAddress.getText();
        Date userDOB = Date.valueOf(txtUserDOB.getText());


        try {
            boolean isAdded = userBO.addUser(
                    new UserDTO(
                            userName,
                            passWord,
                            userEmail,
                            userAddress,
                            userDOB
                    )
            );

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfuly!").show();

            }
        } catch (Exception e) {

        }


    }

    public void onActionBtnUserSearch(ActionEvent actionEvent) {
        String id = txtUserName.getText();

        try {

        UserDTO user = userBO.getUser(id);

        txtUserName.setText(user.getName());
        txtUserPassword.setText(user.getPassword());
        txtUserEmail.setText(user.getEmail());
        txtUserAddress.setText(user.getAddress());
        txtUserDOB.setText(String.valueOf(user.getDateOfBirth()));


    }catch(Exception e){
        System.out.println(e);

    }

}

    public void onActionBtnUserUpdate(ActionEvent actionEvent) {
    }

    public void onActionBtnUserDelete(ActionEvent actionEvent) {
    }


}
