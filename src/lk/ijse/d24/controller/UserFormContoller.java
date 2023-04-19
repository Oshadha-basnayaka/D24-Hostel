package lk.ijse.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;

import java.io.IOException;

public class UserFormContoller {
    public AnchorPane pane;
    public TextField txtUserName;
    public TextField txtUserEmail;
    public TextField txtUserAddress;
    public TextField txtUserDOB;
    public TextField txtUserPassword;

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



    }

    public void onActionBtnUserSearch(ActionEvent actionEvent) {
    }

    public void onActionBtnUserUpdate(ActionEvent actionEvent) {
    }

    public void onActionBtnUserDelete(ActionEvent actionEvent) {
    }
}
