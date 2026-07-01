package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.KnowledgeRepository;
import model.Putusan;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import java.io.File;
import java.net.URL;

public class DashboardController {

    @FXML private BorderPane rootPane;
    @FXML private VBox sideBar;
    @FXML private Button btnHamburger;
    @FXML private Button btnDashboard;
    @FXML private Button btnLogout;
    @FXML private Button btnTambahPutusan;
    @FXML private TextField txtSearch;

    @FXML private TableView<Putusan> tablePutusan;
    @FXML private TableColumn<Putusan, String> colNoPutusan;
    @FXML private TableColumn<Putusan, String> colTanggal;
    @FXML private TableColumn<Putusan, String> colTerdakwa;
    @FXML private TableColumn<Putusan, String> colKlasifikasi;
    @FXML private TableColumn<Putusan, String> colAksi;    @FXML private BarChart<String, Number> chartTrenKasus;
    @FXML private PieChart chartKlasifikasi;

    @FXML private Label lblTotalArsip;
    @FXML private Label lblKasusNarkotika;
    @FXML private Label lblGol1Persen;
    @FXML private Label lblGol1Total;
    @FXML private Label lblGol2Persen;
    @FXML private Label lblGol2Total;
    @FXML private Label lblLainnyaPersen;
    @FXML private Label lblLainnyaTotal;

    private KnowledgeRepository repository;

    private VBox miniSidebar;
    private Button btnMiniHamburger;

    @FXML
    public void initialize() {
        repository = new KnowledgeRepository();

        colNoPutusan.setCellValueFactory(new PropertyValueFactory<>("nomorPerkara"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggalPutusan"));
        colTerdakwa.setCellValueFactory(new PropertyValueFactory<>("namaTerdakwa"));
        colKlasifikasi.setCellValueFactory(new PropertyValueFactory<>("jenisNarkotika"));

        setupActionColumn();

        refreshTable();
        createMiniSidebar();

        btnLogout.setOnAction(e -> handleLogout());
        btnTambahPutusan.setOnAction(e -> openFormModal());
        btnHamburger.setOnAction(e -> toggleSidebar());
        btnDashboard.setOnAction(e -> handleRefreshDashboard());

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Putusan> hasilCari = FXCollections.observableArrayList(repository.cari(newValue));
            tablePutusan.setItems(hasilCari);
        });

        setupCharts();
    }

    private void setupActionColumn() {
        Callback<TableColumn<Putusan, String>, TableCell<Putusan, String>> cellFactory = (param) -> {
            return new TableCell<Putusan, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button btnDetail = new Button("Detail");
                        Button btnHapus = new Button("Hapus");

                        String styleDetailNormal = "-fx-background-color: transparent; -fx-border-color: #38bdf8; -fx-text-fill: #38bdf8; -fx-border-radius: 4; -fx-cursor: hand; -fx-font-weight: bold;";
                        String styleDetailHover = "-fx-background-color: #38bdf8; -fx-text-fill: #0f172a; -fx-border-radius: 4; -fx-cursor: hand; -fx-font-weight: bold;";
                        btnDetail.setStyle(styleDetailNormal);
                        btnDetail.setOnMouseEntered(e -> btnDetail.setStyle(styleDetailHover));
                        btnDetail.setOnMouseExited(e -> btnDetail.setStyle(styleDetailNormal));

                        String styleHapusNormal = "-fx-background-color: transparent; -fx-border-color: #ef4444; -fx-text-fill: #ef4444; -fx-border-radius: 4; -fx-cursor: hand; -fx-font-weight: bold;";
                        String styleHapusHover = "-fx-background-color: #ef4444; -fx-text-fill: #0f172a; -fx-border-radius: 4; -fx-cursor: hand; -fx-font-weight: bold;";
                        btnHapus.setStyle(styleHapusNormal);
                        btnHapus.setOnMouseEntered(e -> btnHapus.setStyle(styleHapusHover));
                        btnHapus.setOnMouseExited(e -> btnHapus.setStyle(styleHapusNormal));

                        btnDetail.setOnAction(event -> {
                            Putusan putusanTerpilih = getTableView().getItems().get(getIndex());
                            lihatDetail(putusanTerpilih);
                        });

                        btnHapus.setOnAction(event -> {
                            Putusan putusanTerpilih = getTableView().getItems().get(getIndex());
                            hapusData(putusanTerpilih);
                        });

                        HBox actionButtons = new HBox(btnDetail, btnHapus);
                        actionButtons.setStyle("-fx-alignment: center-left; -fx-spacing: 10;");

                        setGraphic(actionButtons);
                        setText(null);
                    }
                }
            };
        };
        colAksi.setCellFactory(cellFactory);
    }

    private void hapusData(Putusan putusan) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi Hapus Data");
        alert.setHeaderText("Peringatan: Menghapus Data Perkara");
        alert.setContentText("Apakah Anda yakin ingin menghapus data perkara " + putusan.getNomorPerkara() + " atas nama " + putusan.getNamaTerdakwa() + "?\n\nTindakan ini tidak dapat dibatalkan.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            boolean berhasil = repository.hapus(putusan.getNomorPerkara());
            if (berhasil) {
                refreshTable();            }
        }
    }

    private void lihatDetail(Putusan putusan) {
        try {
            File fxmlFile = new File("src/main/resources/fxml/FormModalView.fxml");
            URL fxmlUrl = fxmlFile.toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            ModalController modalCtrl = loader.getController();
            modalCtrl.setDependencies(repository, this);

            modalCtrl.setPutusanEdit(putusan);

            Stage modalStage = new Stage();
            modalStage.setTitle("Detail / Edit Putusan - " + putusan.getNomorPerkara());
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(btnTambahPutusan.getScene().getWindow());
            modalStage.setScene(new Scene(root));
            modalStage.setResizable(false);
            modalStage.showAndWait();
        } catch (Exception e) {
            System.err.println("Gagal memuat FormModalView: " + e.getMessage());
        }
    }

    private void createMiniSidebar() {
        btnMiniHamburger = new Button("☰");
        btnMiniHamburger.getStyleClass().add("btn-hamburger");
        btnMiniHamburger.setCursor(javafx.scene.Cursor.HAND);
        btnMiniHamburger.setOnAction(e -> toggleSidebar());

        miniSidebar = new VBox(btnMiniHamburger);
        miniSidebar.setAlignment(Pos.TOP_CENTER);
        miniSidebar.setPadding(new Insets(30, 0, 0, 0));
        miniSidebar.setStyle("-fx-background-color: #1e293b; -fx-border-color: #334155; -fx-border-width: 0 1 0 0;");
        miniSidebar.setPrefWidth(70);
    }

    private void toggleSidebar() {
        if (rootPane.getLeft() == sideBar) {
            rootPane.setLeft(miniSidebar);
        } else {
            rootPane.setLeft(sideBar);
        }
    }

    private void handleRefreshDashboard() {
        txtSearch.clear();
        refreshTable();
    }

    private void setupCharts() {
        chartTrenKasus.getData().clear();
        chartKlasifikasi.getData().clear();

        int[] kasusPerBulan = new int[12];
        int gol1 = 0;
        int gol2 = 0;
        int lainnya = 0;

        int totalData = repository.getDaftarPutusan().size();
        lblTotalArsip.setText(String.valueOf(totalData));
        lblKasusNarkotika.setText(String.valueOf(totalData));

        for (Putusan p : repository.getDaftarPutusan()) {
            try {
                String tgl = p.getTanggalPutusan();
                if (tgl != null && tgl.length() >= 5) {
                    String stringBulan = tgl.substring(3, 5);
                    int indexBulan = Integer.parseInt(stringBulan) - 1;
                    if (indexBulan >= 0 && indexBulan < 12) kasusPerBulan[indexBulan]++;
                }
            } catch (Exception e) {}

            String jenis = p.getJenisNarkotika() != null ? p.getJenisNarkotika().toLowerCase() : "";
            if (jenis.contains("sabu") || jenis.contains("ganja") || jenis.contains("ekstasi") || jenis.contains("heroin")) {
                gol1++;
            } else if (jenis.contains("sintetis") || jenis.contains("alprazolam")) {
                gol2++;
            } else {
                lainnya++;
            }
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        String[] namaBulan = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun"};
        for (int i = 0; i < 6; i++) {
            series.getData().add(new XYChart.Data<>(namaBulan[i], kasusPerBulan[i]));
        }
        chartTrenKasus.getData().add(series);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        if (gol1 > 0) pieChartData.add(new PieChart.Data("Golongan I", gol1));
        if (gol2 > 0) pieChartData.add(new PieChart.Data("Golongan II", gol2));
        if (lainnya > 0) pieChartData.add(new PieChart.Data("Lainnya", lainnya));
        chartKlasifikasi.setData(pieChartData);

        for (PieChart.Data data : chartKlasifikasi.getData()) {
            if (data.getName().equals("Golongan I")) {
                data.getNode().setStyle("-fx-pie-color: #38bdf8;");            } else if (data.getName().equals("Golongan II")) {
                data.getNode().setStyle("-fx-pie-color: #f472b6;");            } else if (data.getName().equals("Lainnya")) {
                data.getNode().setStyle("-fx-pie-color: #fb923c;");            }
        }

        int totalPie = gol1 + gol2 + lainnya;
        if (totalPie > 0) {
            int pctGol1 = (int) Math.round(((double) gol1 / totalPie) * 100);
            int pctGol2 = (int) Math.round(((double) gol2 / totalPie) * 100);
            int pctLainnya = (int) Math.round(((double) lainnya / totalPie) * 100);
            lblGol1Total.setText(String.valueOf(gol1));
            lblGol1Persen.setText(pctGol1 + "%");

            lblGol2Total.setText(String.valueOf(gol2));
            lblGol2Persen.setText(pctGol2 + "%");

            lblLainnyaTotal.setText(String.valueOf(lainnya));
            lblLainnyaPersen.setText(pctLainnya + "%");
        } else {
            lblGol1Persen.setText("0%"); lblGol1Total.setText("0");
            lblGol2Persen.setText("0%"); lblGol2Total.setText("0");
            lblLainnyaPersen.setText("0%"); lblLainnyaTotal.setText("0");
        }
    }

    public void refreshTable() {
        ObservableList<Putusan> listData = FXCollections.observableArrayList(repository.getDaftarPutusan());
        tablePutusan.setItems(listData);
        setupCharts();
    }

    private void handleLogout() {
        try {
            File fxmlFile = new File("src/main/resources/fxml/LoginView.fxml");
            URL fxmlUrl = fxmlFile.toURI().toURL();
            Parent root = FXMLLoader.load(fxmlUrl);

            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.setScene(new Scene(root, 900, 600));
            stage.centerOnScreen();
        } catch (Exception e) {
            System.err.println("Gagal memuat LoginView: " + e.getMessage());
        }
    }

    private void openFormModal() {
        try {
            File fxmlFile = new File("src/main/resources/fxml/FormModalView.fxml");
            URL fxmlUrl = fxmlFile.toURI().toURL();

            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            ModalController modalCtrl = loader.getController();
            modalCtrl.setDependencies(repository, this);

            Stage modalStage = new Stage();
            modalStage.setTitle("Tambah Data Putusan");
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(btnTambahPutusan.getScene().getWindow());
            modalStage.setScene(new Scene(root));
            modalStage.setResizable(false);
            modalStage.showAndWait();

        } catch (Exception e) {
            System.err.println("Gagal memuat FormModalView: " + e.getMessage());
        }
    }
}