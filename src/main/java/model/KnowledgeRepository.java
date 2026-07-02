package model;

import java.util.ArrayList;

public class KnowledgeRepository {
    
    private ArrayList<Putusan> daftarPutusan = new ArrayList<>();

    
    public KnowledgeRepository() {
        inisialisasiDataSampel();
    }

    private void inisialisasiDataSampel() {
        
        daftarPutusan.add(new Putusan("01/Pid.Sus/2026/PN.Mlg", "PN Malang", "10-01-2026", "Ahmad Fauzi", 28, "Sabu", 2, "Pasal 114 ayat 1", "Kurir", 5, 1000000000.0, "Hadi, S.H."));
        daftarPutusan.add(new Putusan("02/Pid.Sus/2026/PN.Mlg", "PN Malang", "12-01-2026", "Budi Santoso", 34, "Ganja", 50, "Pasal 111 ayat 1", "Pengguna", 4, 800000000.0, "Rian, S.H."));
        daftarPutusan.add(new Putusan("03/Pid.Sus/2026/PN.Mlg", "PN Malang", "15-01-2026", "Citra Dewi", 23, "Ekstasi", 10, "Pasal 112 ayat 1", "Kurir", 6, 1000000000.0, "Siti, S.H."));
        daftarPutusan.add(new Putusan("04/Pid.Sus/2026/PN.Sby", "PN Surabaya", "18-01-2026", "Dedi Kurniawan", 40, "Sabu", 100, "Pasal 114 ayat 2", "Bandar", 15, 2000000000.0, "Anwar, S.H."));
        daftarPutusan.add(new Putusan("05/Pid.Sus/2026/PN.Sby", "PN Surabaya", "20-01-2026", "Eko Prasetyo", 31, "Sabu", 1, "Pasal 112 ayat 1", "Pengguna", 4, 800000000.0, "Dewi, S.H."));
        daftarPutusan.add(new Putusan("06/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "22-01-2026", "Faisal Reza", 29, "Ganja", 500, "Pasal 111 ayat 2", "Pengedar", 8, 1000000000.0, "Bambang, S.H."));
        daftarPutusan.add(new Putusan("07/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "25-01-2026", "Gita Permata", 25, "Ekstasi", 5, "Pasal 112 ayat 1", "Pengguna", 4, 800000000.0, "Santi, S.H."));
        daftarPutusan.add(new Putusan("08/Pid.Sus/2026/PN.Bdg", "PN Bandung", "27-01-2026", "Hendra Wijaya", 35, "Sabu", 15, "Pasal 114 ayat 2", "Pengedar", 10, 1500000000.0, "Joko, S.H."));
        daftarPutusan.add(new Putusan("09/Pid.Sus/2026/PN.Bdg", "PN Bandung", "29-01-2026", "Indah Sari", 22, "Tembakau Sintetis", 12, "Pasal 112 ayat 1", "Kurir", 5, 800000000.0, "Lilik, S.H."));
        daftarPutusan.add(new Putusan("10/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "02-02-2026", "Joko Susilo", 45, "Ganja", 25, "Pasal 111 ayat 1", "Pengguna", 4, 800000000.0, "Aris, S.H."));
        daftarPutusan.add(new Putusan("11/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "05-02-2026", "Kurniawan", 27, "Sabu", 3, "Pasal 114 ayat 1", "Kurir", 6, 1000000000.0, "Tono, S.H."));
        daftarPutusan.add(new Putusan("12/Pid.Sus/2026/PN.Mlg", "PN Malang", "08-02-2026", "Larasati", 24, "Ekstasi", 50, "Pasal 114 ayat 2", "Pengedar", 12, 1500000000.0, "Hadi, S.H."));
        daftarPutusan.add(new Putusan("13/Pid.Sus/2026/PN.Mlg", "PN Malang", "11-02-2026", "Muhammad Rizky", 33, "Sabu", 0.5, "Pasal 127 ayat 1", "Pengguna", 2, 0.0, "Rian, S.H."));
        daftarPutusan.add(new Putusan("14/Pid.Sus/2026/PN.Sby", "PN Surabaya", "14-02-2026", "Novianti", 26, "Sabu", 8, "Pasal 112 ayat 2", "Kurir", 7, 1000000000.0, "Anwar, S.H."));
        daftarPutusan.add(new Putusan("15/Pid.Sus/2026/PN.Sby", "PN Surabaya", "17-02-2026", "Oki Dermawan", 38, "Ganja", 1000, "Pasal 111 ayat 2", "Bandar", 14, 2000000000.0, "Dewi, S.H."));
        daftarPutusan.add(new Putusan("16/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "20-02-2026", "Putra Pratama", 30, "Sabu", 20, "Pasal 114 ayat 2", "Pengedar", 11, 1500000000.0, "Bambang, S.H."));
        daftarPutusan.add(new Putusan("17/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "23-02-2026", "Qori Sandria", 23, "Tembakau Sintetis", 5, "Pasal 112 ayat 1", "Pengguna", 3, 800000000.0, "Santi, S.H."));
        daftarPutusan.add(new Putusan("18/Pid.Sus/2026/PN.Bdg", "PN Bandung", "26-02-2026", "Riyan Hidayat", 28, "Ganja", 80, "Pasal 111 ayat 1", "Kurir", 5, 800000000.0, "Joko, S.H."));
        daftarPutusan.add(new Putusan("19/Pid.Sus/2026/PN.Bdg", "PN Bandung", "28-02-2026", "Siti Aminah", 36, "Ekstasi", 15, "Pasal 114 ayat 1", "Pengedar", 8, 1000000000.0, "Lilik, S.H."));
        daftarPutusan.add(new Putusan("20/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "02-03-2026", "Taufik Hidayat", 32, "Sabu", 1.5, "Pasal 112 ayat 1", "Pengguna", 4, 800000000.0, "Aris, S.H."));
        daftarPutusan.add(new Putusan("21/Pid.Sus/2026/PN.Mlg", "PN Malang", "05-03-2026", "Utomo Putra", 29, "Sabu", 4, "Pasal 114 ayat 1", "Kurir", 6, 1000000000.0, "Siti, S.H."));
        daftarPutusan.add(new Putusan("22/Pid.Sus/2026/PN.Mlg", "PN Malang", "08-03-2026", "Vina Pandu", 24, "Ganja", 150, "Pasal 111 ayat 1", "Pengedar", 6, 800000000.0, "Hadi, S.H."));
        daftarPutusan.add(new Putusan("23/Pid.Sus/2026/PN.Sby", "PN Surabaya", "11-03-2026", "Wahyu Hidayat", 41, "Sabu", 250, "Pasal 114 ayat 2", "Bandar", 18, 2500000000.0, "Anwar, S.H."));
        daftarPutusan.add(new Putusan("24/Pid.Sus/2026/PN.Sby", "PN Surabaya", "14-03-2026", "Xavier Malik", 27, "Ekstasi", 8, "Pasal 112 ayat 1", "Kurir", 5, 1000000000.0, "Dewi, S.H."));
        daftarPutusan.add(new Putusan("25/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "17-03-2026", "Yayan Ruhian", 37, "Sabu", 12, "Pasal 114 ayat 2", "Pengedar", 9, 1200000000.0, "Bambang, S.H."));
        daftarPutusan.add(new Putusan("26/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "20-03-2026", "Zulkifli", 34, "Ganja", 40, "Pasal 111 ayat 1", "Pengguna", 4, 800000000.0, "Santi, S.H."));
        daftarPutusan.add(new Putusan("27/Pid.Sus/2026/PN.Bdg", "PN Bandung", "23-03-2026", "Andi Wijaya", 26, "Sabu", 2.2, "Pasal 114 ayat 1", "Kurir", 5, 1000000000.0, "Joko, S.H."));
        daftarPutusan.add(new Putusan("28/Pid.Sus/2026/PN.Bdg", "PN Bandung", "26-03-2026", "Bella Safira", 23, "Tembakau Sintetis", 18, "Pasal 114 ayat 1", "Pengedar", 7, 1000000000.0, "Lilik, S.H."));
        daftarPutusan.add(new Putusan("29/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "29-03-2026", "Candra Kirana", 30, "Sabu", 1.1, "Pasal 112 ayat 1", "Pengguna", 4, 800000000.0, "Aris, S.H."));
        daftarPutusan.add(new Putusan("30/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "01-04-2026", "Dani Suka", 35, "Ganja", 65, "Pasal 111 ayat 1", "Kurir", 5, 800000000.0, "Tono, S.H."));
        daftarPutusan.add(new Putusan("31/Pid.Sus/2026/PN.Mlg", "PN Malang", "04-04-2026", "Erlangga", 28, "Sabu", 5, "Pasal 114 ayat 1", "Pengedar", 7, 1000000000.0, "Rian, S.H."));
        daftarPutusan.add(new Putusan("32/Pid.Sus/2026/PN.Mlg", "PN Malang", "07-04-2026", "Fitriani", 25, "Ekstasi", 12, "Pasal 112 ayat 2", "Kurir", 6, 1000000000.0, "Siti, S.H."));
        daftarPutusan.add(new Putusan("33/Pid.Sus/2026/PN.Sby", "PN Surabaya", "10-04-2026", "Guntur Bumi", 43, "Sabu", 500, "Pasal 114 ayat 2", "Bandar", 20, 3000000000.0, "Anwar, S.H."));
        daftarPutusan.add(new Putusan("34/Pid.Sus/2026/PN.Sby", "PN Surabaya", "13-04-2026", "Hany Lestari", 32, "Ganja", 200, "Pasal 111 ayat 2", "Pengedar", 7, 1000000000.0, "Dewi, S.H."));
        daftarPutusan.add(new Putusan("35/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "16-04-2026", "Indra Bekti", 39, "Sabu", 14, "Pasal 114 ayat 2", "Pengedar", 10, 1200000000.0, "Bambang, S.H."));
        daftarPutusan.add(new Putusan("36/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "19-04-2026", "Julia Perez", 27, "Sabu", 0.8, "Pasal 127 ayat 1", "Pengguna", 1, 0.0, "Santi, S.H."));
        daftarPutusan.add(new Putusan("37/Pid.Sus/2026/PN.Bdg", "PN Bandung", "22-04-2026", "Kevin Sanjaya", 24, "Tembakau Sintetis", 4, "Pasal 112 ayat 1", "Pengguna", 3, 800000000.0, "Joko, S.H."));
        daftarPutusan.add(new Putusan("38/Pid.Sus/2026/PN.Bdg", "PN Bandung", "25-04-2026", "Lesti Kejora", 26, "Ekstasi", 22, "Pasal 114 ayat 2", "Pengedar", 9, 1500000000.0, "Lilik, S.H."));
        daftarPutusan.add(new Putusan("39/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "28-04-2026", "Mulyadi", 31, "Ganja", 45, "Pasal 111 ayat 1", "Kurir", 5, 800000000.0, "Aris, S.H."));
        daftarPutusan.add(new Putusan("40/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "01-05-2026", "Nabila Syakieb", 29, "Sabu", 3.5, "Pasal 114 ayat 1", "Kurir", 6, 1000000000.0, "Tono, S.H."));
        daftarPutusan.add(new Putusan("41/Pid.Sus/2026/PN.Mlg", "PN Malang", "04-05-2026", "Oman Rachman", 36, "Sabu", 55, "Pasal 114 ayat 2", "Pengedar", 13, 1500000000.0, "Hadi, S.H."));
        daftarPutusan.add(new Putusan("42/Pid.Sus/2026/PN.Mlg", "PN Malang", "07-05-2026", "Panji Triatmojo", 33, "Ganja", 120, "Pasal 111 ayat 1", "Pengedar", 6, 800000000.0, "Rian, S.H."));
        daftarPutusan.add(new Putusan("43/Pid.Sus/2026/PN.Sby", "PN Surabaya", "10-05-2026", "Queen Marry", 25, "Sabu", 2.5, "Pasal 112 ayat 1", "Kurir", 5, 1000000000.0, "Anwar, S.H."));
        daftarPutusan.add(new Putusan("44/Pid.Sus/2026/PN.Sby", "PN Surabaya", "13-05-2026", "Raffi Ahmad", 38, "Sabu", 1.2, "Pasal 112 ayat 1", "Pengguna", 4, 800000000.0, "Dewi, S.H."));
        daftarPutusan.add(new Putusan("45/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "16-05-2026", "Sule Sutisna", 44, "Ganja", 850, "Pasal 111 ayat 2", "Bandar", 13, 2000000000.0, "Bambang, S.H."));
        daftarPutusan.add(new Putusan("46/Pid.Sus/2026/PN.Jkt", "PN Jakarta", "19-05-2026", "Tora Sudiro", 42, "Sabu", 18, "Pasal 114 ayat 2", "Pengedar", 11, 1500000000.0, "Santi, S.H."));
        daftarPutusan.add(new Putusan("47/Pid.Sus/2026/PN.Bdg", "PN Bandung", "22-05-2026", "Uus Rizky", 31, "Ganja", 30, "Pasal 111 ayat 1", "Pengguna", 4, 800000000.0, "Joko, S.H."));
        daftarPutusan.add(new Putusan("48/Pid.Sus/2026/PN.Bdg", "PN Bandung", "25-05-2026", "Vicky Prasetyo", 35, "Ekstasi", 14, "Pasal 114 ayat 1", "Kurir", 6, 1000000000.0, "Lilik, S.H."));
        daftarPutusan.add(new Putusan("49/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "28-05-2026", "Wulan Guritno", 40, "Sabu", 6, "Pasal 114 ayat 1", "Pengedar", 8, 1000000000.0, "Aris, S.H."));
        daftarPutusan.add(new Putusan("50/Pid.Sus/2026/PN.Yyk", "PN Yogyakarta", "01-06-2026", "Zaskia Gotik", 32, "Sabu", 0.9, "Pasal 127 ayat 1", "Pengguna", 2, 0.0, "Tono, S.H."));
    }

  
    public void simpan(Putusan p) {
        if (p != null) {
            daftarPutusan.add(p);
        }
    }

    public boolean hapus(String nomorPerkara) {
        for (int i = 0; i < daftarPutusan.size(); i++) {
            if (daftarPutusan.get(i).getNomorPerkara().equalsIgnoreCase(nomorPerkara)) {
                daftarPutusan.remove(i);
                return true; 
            }
        }
        return false; 
    }

    public ArrayList<Putusan> cari(String keyword) {
        ArrayList<Putusan> hasilParian = new ArrayList<>();
        for (Putusan p : daftarPutusan) {
            if (p.getNomorPerkara().toLowerCase().contains(keyword.toLowerCase()) || 
                p.getNamaTerdakwa().toLowerCase().contains(keyword.toLowerCase())) {
                hasilParian.add(p);
            }
        }
        return hasilParian;
    }

    public ArrayList<Putusan> getDaftarPutusan() {
        return daftarPutusan;
    }

}
