package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("KMS Narkotika - Login");
            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Error: File LoginView.fxml tidak ditemukan atau gagal dimuat.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}