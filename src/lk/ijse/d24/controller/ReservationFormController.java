package lk.ijse.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.bo.BoFactory;
import lk.ijse.d24.bo.BoType;
import lk.ijse.d24.bo.custom.ReservationBO;
import lk.ijse.d24.dto.ReservationDTO;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;

import java.io.IOException;
import java.sql.Date;

public class ReservationFormController {
    public AnchorPane pane;
    public TableView tblReservation;
    public TextField txtReservationId;
    public TextField txtReservationStatus;
    public TextField txtReservationDate;
    public TextField txtReservationStudentId;
    public TextField txtReservationRoomId;

    ReservationBO reservationBO = (ReservationBO) BoFactory.getInstance().getBO(BoType.RESERVATION);

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

        String id = txtReservationId.getText();
        String status = txtReservationStatus.getText();
        Date date = Date.valueOf(txtReservationDate.getText());
        String reservationStudentId = txtReservationStudentId.getText();
        String reservationRoomId = txtReservationRoomId.getText();

        try {
            boolean isAdded = reservationBO.addReservation(new ReservationDTO(
                    id,
                    date,
                    status,
                    reservationStudentId,
                    reservationRoomId
            ));


            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void onActionBtnReservationSearch(ActionEvent actionEvent) {
        ReservationDTO reservationDTO = reservationBO.getReservation(id)

    }

    public void onActionBtnReservationUpdate(ActionEvent actionEvent) {


        String id = txtReservationId.getText();
        String status = txtReservationStatus.getText();
        Date date = Date.valueOf(txtReservationDate.getText());
        String reservationStudentId = txtReservationStudentId.getText();
        String reservationRoomId = txtReservationRoomId.getText();

        try {
            boolean isUpdate = reservationBO.updateReservation(new ReservationDTO(
                    id,
                    date,
                    status,
                    reservationStudentId,
                    reservationRoomId
            ));


            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void onActionBtnReservationDelete(ActionEvent actionEvent) {
        String id = txtReservationId.getText();

        try {
            boolean isDelete = reservationBO.deleteReservation(id);

            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION, "Reservation Delete Succesfully!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
