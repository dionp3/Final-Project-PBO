package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import library_managebase_byteam6.Connector_db;

public class Buku {
    protected String idbuku;
    protected String judul;
    protected String penulis;
    protected String penerbit;
    protected int stok;

    public Buku(String idbuku, String judul, String penulis, String penerbit, int stok) {
        this.idbuku = idbuku;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.stok = stok;
    }

    public String getIdbuku() {
        return this.idbuku;
    }

    public void setIdbuku(String idbuku) {
        this.idbuku = idbuku;
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return this.penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getStok() {
        return this.stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void insertDatatoDB(String idbuku, String judul, String penulis, String penerbit, int stok) {
        try {
            Connection conn = Connector_db.getConnection();
            
            String sql = "INSERT INTO buku (idbuku, judul, penulis, penerbit, stok) VALUES (?, ?, ? ,? ,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idbuku);
            statement.setString(2, judul);
            statement.setString(3, penulis);
            statement.setString(4, penerbit);
            statement.setInt(5, stok);

            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke dalam database!");
                
            }

            statement.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }
    }}