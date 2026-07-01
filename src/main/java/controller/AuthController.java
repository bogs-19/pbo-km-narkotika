package controller;

import model.AdminRepository; 

public class AuthController {

    private String penggunaAktif;
    private AdminRepository adminRepo;

    public AuthController() {
        this.penggunaAktif = null;
        this.adminRepo = new AdminRepository();
    }

    public boolean verifikasiLogin(String username, String password) {
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            System.err.println("Autentikasi Gagal: Form tidak boleh kosong.");
            return false;
        }

        boolean isKredensialValid = adminRepo.cekKredensial(username, password);

        if (isKredensialValid) {
            this.penggunaAktif = username;
            System.out.println("Login Berhasil dari Database. Sesi aktif: " + penggunaAktif);
            return true;
        } else {
            System.err.println("Login Gagal: Username atau password tidak ditemukan di Database.");
            return false;
        }
    }

    public void logout() {
        System.out.println("Sesi diakhiri untuk: " + this.penggunaAktif);
        this.penggunaAktif = null;
    }

    public String getPenggunaAktif() {
        return penggunaAktif;
    }
}
