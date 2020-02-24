package clientfx;

import database.Car;
import database.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import referanceclass.CarReference;

import java.util.ArrayList;

public class Main extends Application {
    static Stage registrationStage = new Stage();

    @Override
    public void start(Stage primaryStage){
        User user = new User();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("registration .fxml"));
            registrationStage.setTitle("Registration ");
            registrationStage.setScene(new Scene(root, 800, 600));
            registrationStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}