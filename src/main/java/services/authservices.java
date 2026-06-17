package services;

import objects.User;
import dao.GenericDAO;
import panel.karyawanpanel; 
import pages.login;
import pages.admin; // Import halaman admin utama
import util.SecurityUtils;
import com.mongodb.client.model.Filters;
import java.awt.Frame;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;

/**
 * @author mnish
 */
public class authservices {

    // Inisialisasi DAO untuk koleksi "users"
    private final GenericDAO<User> userDAO = new GenericDAO<>("users", User.class);

    /**
     * Melakukan proses login dengan memvalidasi kredensial.
     */
    public void login(String username, String plainPassword, login loginPage) {
        // 1. Mengubah password input menjadi hash SHA-256 untuk keamanan
        String hashedInput = SecurityUtils.getHash(plainPassword, SecurityUtils.SHA_256);

        // 2. Mencari user di database berdasarkan username DAN password hash
        User user = userDAO.findOne(Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", hashedInput)
        ));

        // 3. Validasi hasil pencarian
        if (user != null) {
            // Update waktu login terakhir
            user.setLastLogin(LocalDateTime.now());
            userDAO.update(Filters.eq("username", username), user);

            // Berhasil: Masuk ke Halaman Admin Utama (admin.java)
            JOptionPane.showMessageDialog(null, "Selamat Datang, " + user.getFullname());
            
            pages.admin menuUtama = new pages.admin(); 
            menuUtama.setLocationRelativeTo(null); 
            menuUtama.setVisible(true);
            menuUtama.setExtendedState(Frame.MAXIMIZED_BOTH); 
            
            loginPage.setVisible(false); // Sembunyikan halaman login
        } else {
            // Gagal: Notifikasi Error
            JOptionPane.showMessageDialog(null,
                    "Username atau Password Salah!",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metode untuk menambahkan user/admin baru ke database.
     */
    public void registerUser(String fullname, String username, String plainPassword) {
        // 1. Proses Hashing: Mengamankan password mentah menggunakan SHA-256
        String hashedPassword = SecurityUtils.getHash(plainPassword, SecurityUtils.SHA_256);

        // 2. Instansiasi Objek: Membuat objek User baru dengan password yang sudah di-hash
        User newUser = new User(fullname, username, hashedPassword, null);

        // 3. Operasi Create: Menyimpan dokumen user ke koleksi MongoDB melalui GenericDAO
        try {
            userDAO.save(newUser); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mendaftarkan user: " + e.getMessage());
        }
    }
}