package lk.ijse.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;

import java.io.IOException;

public class RoomFormController {
    public AnchorPane pane;
    public TableView tblRoom;
    public TextField txtRoomId;
    public TextField txtRoomType;
    public TextField txtRoomKeyMoney;
    public TextField txtRoomQty;

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

    public void onActionBtnRoomAdd(ActionEvent actionEvent) {
    }

    public void onActionBtnRoomSearch(ActionEvent actionEvent) {
    }

    public void onActionBtnRoomUpdate(ActionEvent actionEvent) {
    }

    public void onActionBtnRoomDelete(ActionEvent actionEvent) {
    }
}
