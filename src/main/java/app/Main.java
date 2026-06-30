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

        // === JURUS BYPASS CLASSPATH INTELLIJ ===
        // Mengarahkan aplikasi untuk membuka LoginView pertama kali
        File fxmlFile = new File("src/main/resources/fxml/LoginView.fxml");
        URL fxmlUrl = fxmlFile.toURI().toURL();
        Parent root = FXMLLoader.load(fxmlUrl);
        // =======================================

        // Sesuaikan dimensi dengan desain LoginView kamu
        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("KMS Command Center - Narkotika");
        primaryStage.setScene(scene);

        // Kunci ukuran layar agar desain login yang rapi tidak rusak ditarik user
        primaryStage.setResizable(false);

        // Memastikan jendela selalu muncul pas di tengah layar monitor
        primaryStage.centerOnScreen();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}