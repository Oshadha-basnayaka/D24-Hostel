package lk.ijse.d24.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.bo.BoFactory;
import lk.ijse.d24.bo.BoType;
import lk.ijse.d24.bo.custom.ReservationBO;
import lk.ijse.d24.bo.custom.UserBO;
import lk.ijse.d24.dto.UserDTO;
import lk.ijse.d24.util.Navigation;
import lk.ijse.d24.util.Routes;
import lk.ijse.d24.util.Validation;

import java.io.IOException;

public class   MainLoginFormController {
    public JFXTextField txtUserName;
    public JFXTextField txtPWord;
    public AnchorPane pane;
    public ImageView imgHidePassword;
    public JFXPasswordField txtHidePassword;
    public ImageView imgShowPassword;

    UserBO userBO = (UserBO) BoFactory.getInstance().getBO(BoType.USER);

    public void onActionBtnLogin(ActionEvent actionEvent) throws IOException {
        login();
    }


    private void login() throws IOException {

        try {

            UserDTO userDTO = userBO.getUser(txtUserName.getText());

            if ( (txtUserName.getText().equals(userDTO.getName()) && txtPWord.getText().equals(userDTO.getPassword()))   ||  (txtUserName.getText().equals(userDTO.getName()) && txtHidePassword.getText().equals(userDTO.getPassword()))     ) {

                System.out.println("done");

                Navigation.navigate(Routes.DASHBOAD, pane);
            }
            else {
                new Alert(Alert.AlertType.WARNING, "wrong password or user name!").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "wrong password or user name!").show();
        }

//
//        if (txtUserName.getText().equals("admin") && txtPWord.getText().equals("1234")) {
//
//            System.out.println("done");
//
//            Navigation.navigate(Routes.DASHBOAD, pane);
//
//        }
//        else if (TxtUserName.getText().equals("reception") && TxtPassword.getText().equals("1234")) {
//
//            System.out.println("done");
//
//            Navigation.navigate(Routes.DASHBOADRECEPTION, pane);
//
//        }

//        else {
//            Notification();
//        }


    }

    public void Notification(){

        Alert alert = new Alert(Alert.AlertType.ERROR);// line 1
        alert.setTitle("Incorrect Password");// line 2
        alert.setHeaderText("invalid username or password!!!");// line 3
        alert.setContentText("Please, check your User Name and Password, and try again!");// line 4
        alert.showAndWait(); // line 5
//        alert.initModality(Modality.APPLICATION_MODAL);

    }

    public void showPasswordOnAction(MouseEvent mouseEvent) {
        txtPWord.setText(txtHidePassword.getText());
        txtHidePassword.setVisible(false);
        imgHidePassword.setVisible(false);
        txtPWord.setVisible(true);
        imgShowPassword.setVisible(true);
    }

    public void hidePasswordOnAction(MouseEvent mouseEvent) {
        txtHidePassword.setText(txtPWord.getText());
        txtHidePassword.setVisible(true);
        imgHidePassword.setVisible(true);
        txtPWord.setVisible(false);
        imgShowPassword.setVisible(false);
    }

    public void onActionBtnCreateNewUser(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.USER, pane);
    }
}
