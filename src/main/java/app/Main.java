package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Import tambahan untuk jalur kasar
import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // === JURUS BYPASS CLASSPATH INTELLIJ ===
        // Memaksa Java membaca file langsung dari path hard disk
        File fxmlFile = new File("src/main/resources/fxml/DashboardView.fxml");
        URL fxmlUrl = fxmlFile.toURI().toURL();
        Parent root = FXMLLoader.load(fxmlUrl);
        // =======================================

        Scene scene = new Scene(root);

        primaryStage.setTitle("KMS Command Center - Narkotika");
        primaryStage.setScene(scene);

        primaryStage.setWidth(1366);
        primaryStage.setHeight(768);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}