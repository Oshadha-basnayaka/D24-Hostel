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
import lk.ijse.d24.bo.custom.RoomBO;
import lk.ijse.d24.dto.RoomDTO;
import lk.ijse.d24.dto.StudentDTO;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;
import lk.ijse.d24.view.TM.StudentTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoomFormController {
    public AnchorPane pane;
    public TableView tblRoom;
    public TextField txtRoomId;
    public TextField txtRoomType;
    public TextField txtRoomKeyMoney;
    public TextField txtRoomQty;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colQty;

    public void initialize() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));



        try {
            loadRooms(roomBO.getAllRooms());
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    RoomBO roomBO = (RoomBO) BoFactory.getInstance().getBO(BoType.ROOM);

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
        String id = txtRoomId.getText();
        String roomType = txtRoomType.getText();
        String keyMoney = txtRoomKeyMoney.getText();
        int qty =  Integer.parseInt(txtRoomQty.getText());

        try {
            boolean isAdded = roomBO.addRoom(new RoomDTO(
                    id,
                    roomType,
                    keyMoney,
                    qty
            ));
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room Added Successfully!").show();

            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    public void onActionBtnRoomSearch(ActionEvent actionEvent) {

        String id = txtRoomId.getText();

        try {
            RoomDTO roomDTO = roomBO.getRoom(id);
            txtRoomId.setText(roomDTO.getId());
            txtRoomType.setText(roomDTO.getRoomType());
            txtRoomKeyMoney.setText(roomDTO.getKeyMoney());
            txtRoomQty.setText(String.valueOf(roomDTO.getQty()));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void onActionBtnRoomUpdate(ActionEvent actionEvent) {

        String id = txtRoomId.getText();
        String roomType = txtRoomType.getText();
        String keyMoney = txtRoomKeyMoney.getText();
        int qty =  Integer.parseInt(txtRoomQty.getText());

        try {
            boolean isUpdate = roomBO.updateRoom(new RoomDTO(
                    id,
                    roomType,
                    keyMoney,
                    qty
            ));
            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room update Successfully!").show();

            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

    public void onActionBtnRoomDelete(ActionEvent actionEvent) {

        String id = txtRoomId.getText();

        try {
            boolean isDelete = roomBO.deleteRoom(id);

            if (isDelete){

                new Alert(Alert.AlertType.CONFIRMATION, "Room Delete Successfully!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadRooms(ArrayList<RoomDTO> roomDTOArrayList) {
        tblRoom.setItems(FXCollections.observableArrayList(
                roomDTOArrayList.stream().map(roomDTO -> {
                    return new RoomDTO(
                            roomDTO.getId(),
                            roomDTO.getRoomType(),
                            roomDTO.getKeyMoney(),
                            roomDTO.getQty()

                    );
                }).collect(Collectors.toList())));
    }
}
