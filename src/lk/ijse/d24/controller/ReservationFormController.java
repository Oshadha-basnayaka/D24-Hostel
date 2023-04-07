package lk.ijse.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;

import java.io.IOException;

public class ReservationFormController {
    public AnchorPane pane;
    public TableView tblReservation;
    public TextField txtReservationId;
    public TextField txtReservationStatus;
    public TextField txtReservationDate;

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

    public void onActionBtnReservationAdd(ActionEvent actionEvent) {
    }

    public void onActionBtnReservationSearch(ActionEvent actionEvent) {
    }

    public void onActionBtnReservationUpdate(ActionEvent actionEvent) {
    }

    public void onActionBtnReservationDelete(ActionEvent actionEvent) {
    }
}
