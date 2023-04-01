package lk.ijse.d24.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("Login Form");
                setUi("MainLoginForm.fxml");
                break;
            case DASHBOAD:
                window.setTitle("Dashboad Form");
                setUi("DashboadForm.fxml");
                break;
            case STUDENT:
                window.setTitle("Student Form");
                setUi("StudentForm.fxml");
                break;
            case ROOM:
                window.setTitle("Room Form");
                setUi("RoomForm.fxml");
                break;
            case RESERVATION:
                window.setTitle("Reservation Form");
                setUi("ReservationForm.fxml");
                break;
            case USER:
                window.setTitle("User Form");
                setUi("UserForm.fxml");
                break;
            default:


                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }


    }

    private static void setUi(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/d24/view/" + location)));
    }

}
