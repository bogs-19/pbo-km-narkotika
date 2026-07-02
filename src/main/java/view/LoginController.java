package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class LoginController {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;

    @FXML
    public void initialize() {
        btnLogin.setOnAction(event -> handleLogin());
    }

    private void handleLogin() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if ("admin".equals(username) && "admin123".equals(password)) {
            masukKeDashboard();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Akses Ditolak");
            alert.setHeaderText("Kredensial Tidak Valid");
            alert.setContentText("Username atau password yang Anda masukkan salah.");
            alert.showAndWait();
        }
    }

    private void masukKeDashboard() {
        try {
            File fxmlFile = new File("src/main/resources/fxml/DashboardView.fxml");
            URL fxmlUrl = fxmlFile.toURI().toURL();
            Parent root = FXMLLoader.load(fxmlUrl);

            Stage stage = (Stage) btnLogin.getScene().getWindow();
            Scene dashboardScene = new Scene(root, 1366, 768);

            stage.setScene(dashboardScene);
            stage.centerOnScreen();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Gagal membuka Dashboard! Cek path file FXML.");
        }
    }
}