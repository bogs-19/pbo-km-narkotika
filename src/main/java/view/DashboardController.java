package view;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class DashboardController {

    @FXML
    private BarChart<String, Number> chartTrenKasus;

    @FXML
    private PieChart chartKlasifikasi;

    @FXML
    public void initialize() {
        // Matikan animasi langsung dari Java
        chartTrenKasus.setAnimated(false);

        // --- 1. MENGISI DATA DIAGRAM BATANG (TANPA Platform.runLater) ---
        XYChart.Series<String, Number> seriesTotal = new XYChart.Series<>();
        seriesTotal.setName("Total Kasus");
        seriesTotal.getData().add(new XYChart.Data<>("Jan", 150));
        seriesTotal.getData().add(new XYChart.Data<>("Feb", 180));
        seriesTotal.getData().add(new XYChart.Data<>("Mar", 210));
        seriesTotal.getData().add(new XYChart.Data<>("Apr", 190));
        seriesTotal.getData().add(new XYChart.Data<>("Mei", 240));
        seriesTotal.getData().add(new XYChart.Data<>("Jun", 280));

        XYChart.Series<String, Number> seriesNarkotika = new XYChart.Series<>();
        seriesNarkotika.setName("Narkotika");
        seriesNarkotika.getData().add(new XYChart.Data<>("Jan", 100));
        seriesNarkotika.getData().add(new XYChart.Data<>("Feb", 110));
        seriesNarkotika.getData().add(new XYChart.Data<>("Mar", 130));
        seriesNarkotika.getData().add(new XYChart.Data<>("Apr", 120));
        seriesNarkotika.getData().add(new XYChart.Data<>("Mei", 150));
        seriesNarkotika.getData().add(new XYChart.Data<>("Jun", 190));

        chartTrenKasus.getData().addAll(seriesTotal, seriesNarkotika);


        // --- 2. MENGISI DATA DIAGRAM LINGKARAN ---
        chartKlasifikasi.getData().add(new PieChart.Data("Gol I", 60));
        chartKlasifikasi.getData().add(new PieChart.Data("Gol II", 25));
        chartKlasifikasi.getData().add(new PieChart.Data("Gol III", 10));
        chartKlasifikasi.getData().add(new PieChart.Data("Lainnya", 5));
    }
}