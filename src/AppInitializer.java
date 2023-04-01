import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


//        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/d24/view/loginForm.fxml"))));
//        primaryStage.setTitle("D | 24 Hostel Management System");
//        /*primaryStage.getIcons().add(image);*/
//        primaryStage.centerOnScreen();
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.show();

        URL resource = this.getClass().getResource("/lk/ijse/d24/view/MainLoginForm.fxml");
        Parent window = FXMLLoader.load(resource);
        Scene scene = new Scene(window);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Loging Form");
        primaryStage.centerOnScreen();
        primaryStage.setFullScreen(true);
        primaryStage.setMaximized(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();


        Session Session = SessionFactoryConfiguration.getInstance().getSession();


    }


}
