package model;

public class AdminRepository {
    public AdminRepository() {
    }
    public boolean cekKredensial(String username, String password) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return true;
        }
        return false;
    }
}