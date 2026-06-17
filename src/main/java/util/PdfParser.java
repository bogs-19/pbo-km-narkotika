package util;

import javafx.concurrent.Task;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PdfParser {

    /**
     * Mengekstrak teks mentah dari file PDF dan memotongnya menggunakan Regex.
     * @param fileFisik Berkas dokumen PDF pengadilan.
     * @return Array String berisi 12 elemen yang siap diubah menjadi objek Putusan.
     */
    public static String[] ekstrakTeksPDF(File fileFisik) {
        String[] hasilData = new String[12];

        for (int i = 0; i < 12; i++) hasilData[i] = "-";

        try (PDDocument document = PDDocument.load(fileFisik)) {

            PDFTextStripper stripper = new PDFTextStripper();
            String teksMentah = stripper.getText(document);

            // ==========================================================
            // REGEX ENGINE: Logika Pemotongan Teks
            // ==========================================================

            Pattern polaNomor = Pattern.compile("Nomor\\s+([\\w/.-]+)");
            Matcher matcherNomor = polaNomor.matcher(teksMentah);
            if (matcherNomor.find()) {
                hasilData[0] = matcherNomor.group(1);
            }

        } catch (IOException e) {
            System.err.println("Gagal membaca file PDF: " + fileFisik.getName());
            e.printStackTrace();
        }

        return hasilData;
    }

    /**
     * Fungsi Asinkronus: Membungkus eksekusi parsing masif ke latar belakang (Background Thread).
     * @param folderPdf Direktori tempat berkas-berkas PDF disimpan.
     * @return Task JavaFX yang dapat diikat (bind) ke ProgressBar di UI.
     */
    public static Task<List<String[]>> buatTaskEkstraksiMassal(File folderPdf) {
        return new Task<>() {
            @Override
            protected List<String[]> call() throws Exception {
                List<String[]> kumpulanDataBaru = new ArrayList<>();

                File[] files = folderPdf.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

                if (files == null || files.length == 0) {
                    updateMessage("Folder kosong atau tidak ditemukan.");
                    return kumpulanDataBaru;
                }

                int totalFile = files.length;

                for (int i = 0; i < totalFile; i++) {
                    if (isCancelled()) {
                        break;
                    }

                    String[] dataSatuKasus = ekstrakTeksPDF(files[i]);
                    kumpulanDataBaru.add(dataSatuKasus);

                    // ==========================================================
                    // KOMUNIKASI UI ANTI-FREEZE [cite: 28, 29, 32]
                    // ==========================================================
                    updateProgress(i + 1, totalFile);

                    updateMessage("Memproses: " + files[i].getName());
                }

                return kumpulanDataBaru;
            }
        };
    }
}