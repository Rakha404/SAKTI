package objects;

import java.time.LocalDateTime;
import org.bson.types.ObjectId; // Tambahkan import ini

/**
 * @author mnish
 */
public class User {

    private ObjectId id; // Tambahkan field ID sebagai Primary Key MongoDB
    private String fullname;
    private String username;
    private String password; // Tersimpan dalam format Hash SHA-256
    private LocalDateTime lastLogin;

    // 1. Wajib ada Constructor Kosong untuk MongoDB POJO Codec
    public User() {
    }

    public User(String fullname, String username, String password, LocalDateTime lastLogin) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    // Getter dan Setter untuk ID
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    // Getter dan Setter lama tetap dipertahankan
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}