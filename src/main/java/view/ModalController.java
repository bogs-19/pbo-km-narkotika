package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.KnowledgeRepository;
import model.Putusan;

public class ModalController {

    @FXML
    private TextField txtNomor, txtPengadilan, txtTanggal, txtHakim, txtPasal;
    @FXML
    private TextField txtNama, txtUmur, txtBerat, txtVonis, txtDenda;
    @FXML
    private ComboBox<String> cbJenis, cbPeran;
    @FXML
    private Label lblError;
    @FXML
    private Button btnBatal, btnSimpan;

    private KnowledgeRepository repository;
    private DashboardController dashboardController;

    private Putusan putusanEdit;
    private boolean isEditMode = false;

    @FXML
    public void initialize() {
        cbJenis.getItems().addAll("Sabu-sabu", "Ganja", "Ekstasi", "Heroin", "Lainnya");
        cbPeran.getItems().addAll("Bandar", "Pengedar", "Kurir", "Pengguna", "Penyimpan");

        btnBatal.setOnAction(e -> tutupModal());
        btnSimpan.setOnAction(e -> validasiDanKirim());
    }

    public void setDependencies(KnowledgeRepository repo, DashboardController dashboard) {
        this.repository = repo;
        this.dashboardController = dashboard;
    }

    public void setPutusanEdit(Putusan putusan) {
        this.putusanEdit = putusan;
        this.isEditMode = true;
        txtNomor.setText(putusan.getNomorPerkara());
        txtNomor.setDisable(true);
        txtPengadilan.setText(putusan.getPengadilan());
        txtTanggal.setText(putusan.getTanggalPutusan());
        txtHakim.setText(putusan.getNamaHakim());
        txtPasal.setText(putusan.getPasalDilanggar());

        txtNama.setText(putusan.getNamaTerdakwa());
        txtUmur.setText(String.valueOf(putusan.getUmurTerdakwa()));
        txtBerat.setText(String.valueOf(putusan.getBeratBarangBukti()));
        txtVonis.setText(String.valueOf(putusan.getVonisHukuman()));
        txtDenda.setText(String.valueOf(putusan.getVonisDenda()));

        cbJenis.setValue(putusan.getJenisNarkotika());
        cbPeran.setValue(putusan.getPeranTerdakwa());

        btnSimpan.setText("Update Data");
    }

    private void tutupModal() {
        Stage stage = (Stage) btnBatal.getScene().getWindow();
        stage.close();
    }

    private void validasiDanKirim() {
        if (txtNomor.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty() || cbJenis.getValue() == null) {
            lblError.setText("Error: No. Perkara, Nama, dan Jenis Narkotika wajib diisi!");
            lblError.setVisible(true);
            return;
        }

        try {
            String noPerkara = txtNomor.getText();
            String pengadilan = txtPengadilan.getText();
            String tgl = txtTanggal.getText();
            String hakim = txtHakim.getText();
            String pasal = txtPasal.getText();
            String nama = txtNama.getText();
            String jenis = cbJenis.getValue();
            String peran = cbPeran.getValue() != null ? cbPeran.getValue() : "-";

            int umur = Integer.parseInt(txtUmur.getText().trim());
            double berat = Double.parseDouble(txtBerat.getText().trim());
            int vonis = Integer.parseInt(txtVonis.getText().trim());
            double denda = Double.parseDouble(txtDenda.getText().trim());

            Putusan dataBaru = new Putusan(noPerkara, pengadilan, tgl, nama, umur, jenis, berat, pasal, peran, vonis, denda, hakim);

            if (isEditMode) {
                repository.hapus(noPerkara);
            }
            repository.simpan(dataBaru);

            dashboardController.refreshTable();

            lblError.setVisible(false);
            tutupModal();

        } catch (NumberFormatException e) {
            lblError.setText("Error: Umur, Berat, Vonis, & Denda harus berupa ANGKA!");
            lblError.setVisible(true);
        }
    }
}