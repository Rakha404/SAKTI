package objects;

public class Karyawan {

    private String uidRfid;
    private String idKaryawan;
    private String namaLengkap;
    private String divisi;
    private String jabatan;

    public Karyawan() {
    }

    public Karyawan(String uidRfid, String idKaryawan, String namaLengkap, String divisi, String jabatan) {
        this.uidRfid = uidRfid;
        this.idKaryawan = idKaryawan;
        this.namaLengkap = namaLengkap;
        this.divisi = divisi;
        this.jabatan = jabatan;
    }

    

    @Override
    public String toString() {
        return "Karyawan{" + 
                "uidRfid=" + uidRfid + 
                ", idKaryawan=" + idKaryawan + 
                ", namaLengkap=" + namaLengkap + 
                ", divisi=" + divisi +
                ", jabatan=" + jabatan +'}';
    }

    public String getUidRfid() {
        return uidRfid;
    }

    public void setUidRfid(String uidRfid) {
        this.uidRfid = uidRfid;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
    
    public String getJabatan () {
        return jabatan;
    }
    
    public void setJabatan (String jabatan) {
        this.jabatan = jabatan;
    }
    
    
    
    

}
