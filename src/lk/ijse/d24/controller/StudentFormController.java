package lk.ijse.d24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.bo.BoFactory;
import lk.ijse.d24.bo.BoType;
import lk.ijse.d24.bo.custom.StudentBO;
import lk.ijse.d24.dto.StudentDTO;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;

import java.io.IOException;
import java.sql.Date;

public class StudentFormController {
    public AnchorPane pane;
    public TableView tblStudent;
    public TextField txtStudentId;
    public TextField txtStudentContact;
    public TextField txtStudentAddress;
    public TextField txtStudentDob;
    public TextField txtStudentName;
    public TextField txtStudentGender;

    StudentBO studentBO = (StudentBO) BoFactory.getInstance().getBO(BoType.STUDENT);

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

    public void onActionRadioBtnMale(ActionEvent actionEvent) {
    }

    public void onActionRadioBtnFemale(ActionEvent actionEvent) {
    }

    public void onActionBtnStudentAdd(ActionEvent actionEvent) {

        String id = txtStudentId.getId();
        String name= txtStudentName.getText();
        String address = txtStudentAddress.getText();
        Date date = Date.valueOf(txtStudentDob.getText());
        String gender = txtStudentGender.getText();
        int contact = Integer.parseInt(txtStudentContact.getText());

        try {
            boolean isAdded = studentBO.addStudent(new StudentDTO(id, name, contact, address, date, gender));
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"user Added!").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void onActionBtnStudentSearch(ActionEvent actionEvent) {
    }

    public void onActionBtnStudentUpdate(ActionEvent actionEvent) {
    }

    public void onActionBtnStudentDelete(ActionEvent actionEvent) {
    }
}
