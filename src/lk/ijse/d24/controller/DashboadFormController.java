package lk.ijse.d24.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.bo.BoFactory;
import lk.ijse.d24.bo.BoType;
import lk.ijse.d24.bo.custom.ReservationBO;
import lk.ijse.d24.dto.StudentDTO;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DashboadFormController {


    public AnchorPane pane;
    public TableView tblDashBoadKeyMomey;
    public TableColumn coldashkeymoneystudentid;
    public TableColumn coldashkeymoneystudentname;
    public TableColumn coldashkeymoneystatus;
    public TableView tblKeyMoney;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colBob;
    public TableColumn colGender;

    ReservationBO reservationBO = (ReservationBO) BoFactory.getInstance().getBO(BoType.RESERVATION);


    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colBob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        try {
            loadKeyMoneyNotPayStudent(reservationBO.getNotPayStudent());
        }catch (Exception e) {
            System.out.println(e);
        }
    }

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


    private void loadKeyMoneyNotPayStudent(ArrayList<StudentDTO> notPayStudents) {
        tblKeyMoney.setItems(FXCollections.observableArrayList(
                notPayStudents.stream().map(studentDTO -> {
                    return new StudentDTO(
                            studentDTO.getId(),
                            studentDTO.getName(),
                            studentDTO.getContact(),
                            studentDTO.getAddress(),
                            studentDTO.getDob(),
                            studentDTO.getGender()

                    );
                }).collect(Collectors.toList())));
    }

}
