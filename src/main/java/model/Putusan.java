package model;

public class Putusan {
    // 1. Atribut Privat (Private Attributes)
    private String nomorPerkara;
    private String pengadilan;
    private String tanggalPutusan;
    private String namaTerdakwa;
    private int umurTerdakwa;
    private String jenisNarkotika;
    private double beratBarangBukti;
    private String pasalDilanggar;
    private String peranTerdakwa;
    private int vonisHukuman;
    private double vonisDenda;
    private String namaHakim;

    // Tambahan Sprint 2: Counter Variabel Statis
    private static int jumlahDibuat = 0;

    // 2. Constructor Overloading

    // A. No-arg Constructor (Konstruktor Kosong)
    public Putusan() {
        jumlahDibuat++;
    }

    // B. Parameterized Constructor (Konstruktor Lengkap)
    public Putusan(String nomorPerkara, String pengadilan, String tanggalPutusan, String namaTerdakwa,
                   int umurTerdakwa, String jenisNarkotika, double beratBarangBukti, String pasalDilanggar,
                   String peranTerdakwa, int vonisHukuman, double vonisDenda, String namaHakim) {
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.namaTerdakwa = namaTerdakwa;
        this.umurTerdakwa = umurTerdakwa;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBukti = beratBarangBukti;
        this.pasalDilanggar = pasalDilanggar;
        this.peranTerdakwa = peranTerdakwa;
        this.vonisHukuman = vonisHukuman;
        this.vonisDenda = vonisDenda;
        this.namaHakim = namaHakim;

        jumlahDibuat++;
    }

    // Tambahan Sprint 2: Method Getter Statis
    public static int getJumlahDibuat() {
        return jumlahDibuat;
    }

    // Tambahan Sprint 2: Method Overriding toString()
    @Override
    public String toString() {
        return "Nomor Perkara: " + nomorPerkara + " | Nama Terdakwa: " + namaTerdakwa;
    }

    // 3. Encapsulation (Getter dan Setter)
    public String getNomorPerkara() { return nomorPerkara; }
    public void setNomorPerkara(String nomorPerkara) { this.nomorPerkara = nomorPerkara; }

    public String getPengadilan() { return pengadilan; }
    public void setPengadilan(String pengadilan) { this.pengadilan = pengadilan; }

    public String getTanggalPutusan() { return tanggalPutusan; }
    public void setTanggalPutusan(String tanggalPutusan) { this.tanggalPutusan = tanggalPutusan; }

    public String getNamaTerdakwa() { return namaTerdakwa; }
    public void setNamaTerdakwa(String namaTerdakwa) { this.namaTerdakwa = namaTerdakwa; }

    public int getUmurTerdakwa() { return umurTerdakwa; }
    public void setUmurTerdakwa(int umurTerdakwa) { this.umurTerdakwa = umurTerdakwa; }

    public String getJenisNarkotika() { return jenisNarkotika; }
    public void setJenisNarkotika(String jenisNarkotika) { this.jenisNarkotika = jenisNarkotika; }

    public double getBeratBarangBukti() { return beratBarangBukti; }
    public void setBeratBarangBukti(double beratBarangBukti) { this.beratBarangBukti = beratBarangBukti; }

    public String getPasalDilanggar() { return pasalDilanggar; }
    public void setPasalDilanggar(String pasalDilanggar) { this.pasalDilanggar = pasalDilanggar; }

    public String getPeranTerdakwa() { return peranTerdakwa; }
    public void setPeranTerdakwa(String peranTerdakwa) { this.peranTerdakwa = peranTerdakwa; }

    public int getVonisHukuman() { return vonisHukuman; }
    public void setVonisHukuman(int vonisHukuman) { this.vonisHukuman = vonisHukuman; }

    public double getVonisDenda() { return vonisDenda; }
    public void setVonisDenda(double vonisDenda) { this.vonisDenda = vonisDenda; }

    public String getNamaHakim() { return namaHakim; }
    public void setNamaHakim(String namaHakim) { this.namaHakim = namaHakim; }
}