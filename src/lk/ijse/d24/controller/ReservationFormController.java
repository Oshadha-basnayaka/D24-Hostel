package lk.ijse.d24.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.bo.BoFactory;
import lk.ijse.d24.bo.BoType;
import lk.ijse.d24.bo.custom.ReservationBO;
import lk.ijse.d24.bo.custom.StudentBO;
import lk.ijse.d24.dto.ReservationDTO;
import lk.ijse.d24.dto.RoomDTO;
import lk.ijse.d24.dto.StudentDTO;
import lk.ijse.d24.entity.Student;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;
import lk.ijse.d24.view.TM.ReservationTM;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReservationFormController {
    public AnchorPane pane;
    public TableView tblReservation;
    public TextField txtReservationId;
    public TextField txtReservationStatus;
    public TextField txtReservationDate;
    public TextField txtReservationStudentId;
    public TextField txtReservationRoomId;
    public TableColumn colResid;
    public TableColumn colresStudentid;
    public TableColumn colresRoomid;
    public TableColumn colresSatus;
    public TableColumn colresDate;

    public void initialize() {
        colResid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colresDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colresSatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colresStudentid.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        colresRoomid.setCellValueFactory(new PropertyValueFactory<>("RoomId"));



        try {
            loadReservation(reservationBO.getAllReservation());
        } catch (Exception e) {
            System.out.println(e);
        }


    }

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

                loadReservation(reservationBO.getAllReservation());
                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void onActionBtnReservationSearch(ActionEvent actionEvent) {
        ReservationDTO reservationDTO = reservationBO.getReservation(txtReservationId.getText());

        try {


            txtReservationId.setText(reservationDTO.getId());
            txtReservationRoomId.setText(reservationDTO.getRoomId());
            txtReservationStudentId.setText(reservationDTO.getStudentId());
            txtReservationStatus.setText(reservationDTO.getStatus());
            txtReservationDate.setText(String.valueOf(reservationDTO.getDate()));

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input Reservation Id Is Ivalid!\nPlease Try Again..").show();
            System.out.println(e);
        }

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
                loadReservation(reservationBO.getAllReservation());
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
                loadReservation(reservationBO.getAllReservation());
                new Alert(Alert.AlertType.CONFIRMATION, "Reservation Delete Succesfully!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void loadReservation(ArrayList<ReservationDTO> reservationDTOArrayList) {
        tblReservation.setItems(FXCollections.observableArrayList(
                reservationDTOArrayList.stream().map(reservationDTO -> {
                    return new ReservationTM(
                            reservationDTO.getId(),
                            reservationDTO.getDate(),
                            reservationDTO.getStatus(),
                            reservationDTO.getStudentId(),
                            reservationDTO.getRoomId()

                    );
                }).collect(Collectors.toList())));
    }
}
