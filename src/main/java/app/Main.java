package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        File fxmlFile = new File("src/main/resources/fxml/LoginView.fxml");
        URL fxmlUrl = fxmlFile.toURI().toURL();
        Parent root = FXMLLoader.load(fxmlUrl);
        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("KMS Command Center - Narkotika");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);

        primaryStage.centerOnScreen();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}