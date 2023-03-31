package lk.ijse.d24.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;

import java.io.IOException;

public class LoginFormController {


    public JFXTextField txtUserName;
    public JFXTextField txtpWord;
    public AnchorPane pane;

    public void onActionBtnLogin(ActionEvent actionEvent) throws IOException {
        login();
    }


    private void login() throws IOException {

        if (txtUserName.getText().equals("admin") && txtpWord.getText().equals("1234")) {

            System.out.println("done");

            Navigation.navigate(Routes.DASHBOAD, pane);

        }

        else {
            Notification();
        }
    }
    public void Notification(){

        Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        alert.setTitle("Incorrect Password");// line 2
        alert.setHeaderText("invalid username or password!!!");// line 3
        alert.setContentText("Please, check your User Name and Password, and try again!");// line 4
        alert.showAndWait(); // line 5
//        alert.initModality(Modality.APPLICATION_MODAL);

    }

}
