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

        String id = txtStudentId.getText();
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
        String id = txtStudentId.getText();

        try {
            StudentDTO studentDTO = studentBO.getStudent(id);
            txtStudentId.setText(studentDTO.getId());
            txtStudentName.setText(studentDTO.getName());
            txtStudentContact.setText(String.valueOf(studentDTO.getContact()));
            txtStudentAddress.setText(studentDTO.getAddress());
            txtStudentDob.setText(String.valueOf(studentDTO.getDob()));
            txtStudentGender.setText(studentDTO.getGender());

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Input Student Id Is Ivalid!\nPlease Try Again..").show();
            System.out.println(e);
            System.out.println("catch");


        }
    }

    public void onActionBtnStudentUpdate(ActionEvent actionEvent) {
        String id = txtStudentId.getText();
        String name= txtStudentName.getText();
        String address = txtStudentAddress.getText();
        Date date = Date.valueOf(txtStudentDob.getText());
        String gender = txtStudentGender.getText();
        int contact = Integer.parseInt(txtStudentContact.getText());

        try {
            boolean isUpdate = studentBO.updateStudent(new StudentDTO(
                    id,name,contact,address,date,gender
            ));

        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Somthing Went Wrong!\nPlease Try Again..").show();
        }
    }

    public void onActionBtnStudentDelete(ActionEvent actionEvent) {
        String id = txtStudentId.getText();

        try {
            boolean isDelete = studentBO.deleteStudent(id);

            if (isDelete) {
                new Alert(Alert.AlertType.ERROR, "Student Delete Succesfully!").show();

            }

        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Input Student Id Is Ivalid!\nPlease Try Again..").show();
        }

    }
}
