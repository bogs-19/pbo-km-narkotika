package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatistikPutusan {
    private ArrayList<Putusan> daftarPutusan;
    private double rataRataHukumanVonis;
    private double rataRataNominalDenda;
    private String modusJenisNarkotikaTerbanyak;

    // Konstruktor yang menerima data repositori utama
    public StatistikPutusan(ArrayList<Putusan> daftar) {
        this.daftarPutusan = daftar;
        this.rataRataHukumanVonis = 0.0;
        this.rataRataNominalDenda = 0.0;
        this.modusJenisNarkotikaTerbanyak = "Belum Diketahui";
    }

    // Metode fungsional algoritma matematika agregat
    public void hitungSemua() {
        if (daftarPutusan == null || daftarPutusan.isEmpty()) {
            this.rataRataHukumanVonis = 0.0;
            this.rataRataNominalDenda = 0.0;
            this.modusJenisNarkotikaTerbanyak = "Data Kosong";
            return;
        }

        int totalHukuman = 0;
        double totalDenda = 0;
        HashMap<String, Integer> hitungNarkotika = new HashMap<>();

        // Melakukan kalkulasi iterasi matematika menyeluruh (looping loop)
        for (Putusan p : daftarPutusan) {
            totalHukuman += p.getVonisHukuman();
            totalDenda += p.getVonisDenda();

            // Ambil jenis narkotika dan lakukan normalisasi teks (lowercase) untuk akurasi modus
            String jenis = p.getJenisNarkotika() != null ? p.getJenisNarkotika().trim().toLowerCase() : "tidak diketahui";
            hitungNarkotika.put(jenis, hitungNarkotika.getOrDefault(jenis, 0) + 1);
        }

        int jumlahData = daftarPutusan.size();
        this.rataRataHukumanVonis = (double) totalHukuman / jumlahData;
        this.rataRataNominalDenda = totalDenda / jumlahData;

        // Mencari modus jenis narkotika terbanyak
        String modusTerpilih = "Tidak Diketahui";
        int maxKemunculan = -1;

        for (Map.Entry<String, Integer> entry : hitungNarkotika.entrySet()) {
            if (entry.getValue() > maxKemunculan) {
                maxKemunculan = entry.getValue();
                modusTerpilih = entry.getKey();
            }
        }
        
        // Mengembalikan format teks yang rapi (Kapital huruf pertama)
        if (!modusTerpilih.equals("Tidak Diketahui")) {
            this.modusJenisNarkotikaTerbanyak = modusTerpilih.substring(0, 1).toUpperCase() + modusTerpilih.substring(1);
        } else {
            this.modusJenisNarkotikaTerbanyak = modusTerpilih;
        }
    }

    // Getter untuk mengakses hasil perhitungan statistik
    public double getRataRataHukumanVonis() {
        return rataRataHukumanVonis;
    }

    public double getRataRataNominalDenda() {
        return rataRataNominalDenda;
    }

    public String getModusJenisNarkotikaTerbanyak() {
        return modusJenisNarkotikaTerbanyak;
    }
}
