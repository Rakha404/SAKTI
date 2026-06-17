package services;

import dao.GenericDAO;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author mnish
 */
public class logabsensi {
    // 1. Inisialisasi DAO untuk koleksi "log_absensi" [7] (Tetap dipertahankan)
    private final GenericDAO<logabsensi> logDAO = new GenericDAO<>("log_absensi", logabsensi.class);
    
    // 2. Definisikan field properti objek untuk menampung data
    private String id;
    private String hashedUid;
    private LocalDateTime tanggal;
    private String status;

    // 3. Default Constructor (Kosongan)
    public logabsensi() {
    }

    // 4. Constructor dengan 4 Argumen (Menghilangkan error baris 18)
    public logabsensi(String id, String hashedUid, LocalDateTime tanggal, String status) {
        this.id = id;
        this.hashedUid = hashedUid;
        this.tanggal = tanggal;
        this.status = status;
    }
    
    // 5. Fungsi simpanLog bawaanmu
    public void simpanLog(String hashedUid, String status) {
        // Membuat objek LogAbsensi sesuai parameter di sumber [6]
        logabsensi log = new logabsensi(
            UUID.randomUUID().toString(), 
            hashedUid, 
            LocalDateTime.now(), 
            status
        );
        logDAO.save(log); // Menyimpan ke MongoDB [7]
    }
    
    // ===============================================================
    // GETTER & SETTER (Wajib ada supaya GenericDAO bisa membaca datanya)
    // ===============================================================
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getHashedUid() { return hashedUid; }
    public void setHashedUid(String hashedUid) { this.hashedUid = hashedUid; }

    public LocalDateTime getTanggal() { return tanggal; }
    public void setTanggal(LocalDateTime tanggal) { this.tanggal = tanggal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}