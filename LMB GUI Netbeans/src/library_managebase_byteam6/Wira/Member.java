/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_managebase_byteam6.Wira;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Member {
    private String iduser;
    private String nama;
    private String nisnnip;
    private String nohp;
    private String alamat;
    
    public Member (String iduser, String nama, String nisnnip, String nohp, String alamat){
        this.iduser = iduser;
        this.nama = nama;
        this.nisnnip = nisnnip;
        this.nohp = nohp;
        this.alamat = alamat;
    }
    
    public String getIduser(){
        return this.iduser;
    }
    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
    
    public String getNama(){
        return this.nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNisnnip(){
        return this.nisnnip;
    }
    public void setNisnnip(String nisnnip) {
        this.nisnnip = nisnnip;
    }
    
    public String getNohp(){
        return this.nohp;
    }
    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
    
    public String getAlamat(){
        return this.alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void tambahMember(String iduser, String nama, String nisnnip, String nohp, String alamat){
        this.iduser = iduser;
        this.nama = nama;
        this.nisnnip = nisnnip;
        this.nohp = nohp;
        this.alamat = alamat;
        System.out.println("Berhasil menambahkan data member");
    }
    
    public void Show(String iduser, String nama, String nisnnip, String nohp, String alamat){
        this.iduser = iduser;
        this.nama = nama;
        this.nisnnip = nisnnip;
        this.nohp = nohp;
        this.alamat = alamat;
        System.out.println("Menampilkan data member");
    }
    
     public void showDatafromDB() {
    try {
        String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
        String username = "root";
        String password = "ardhi@26";

        
        Connection conn = DriverManager.getConnection(url, username, password);

        // Menyiapkan pernyataan SQL untuk mendapatkan data dari tabel
        String sql = "SELECT * FROM member";
        PreparedStatement statement = conn.prepareStatement(sql);

        // Menjalankan pernyataan SQL dan mendapatkan hasilnya
        ResultSet rs = statement.executeQuery();

        // Mengambil metadata hasil query
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // Menghapus data sebelumnya dari tabel
        DefaultTableModel model = (DefaultTableModel) tabel_member.getModel();
        model.setRowCount(0);

        // Menambahkan baris data ke dalam tabel
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                rowData[i] = rs.getObject(i + 1);
            }
            model.addRow(rowData);
        }

        // Menutup koneksi dan pernyataan SQL
        rs.close();
        statement.close();
        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
    }
     }
    
     public void insertDatatoDB(String idmember, String nama, String nisn, String nohp, String alamat) {
        try {
           
            String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
            String username = "root";
            String password = "ardhi@26";

            
            Connection conn = DriverManager.getConnection(url, username, password);

            
            String sql = "INSERT INTO member (idmember, nama, nisn, nohp, alamat) VALUES (?, ?, ? ,? ,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idmember);
            statement.setString(2, nama);
            statement.setString(3, nisn);
            statement.setString(4, nohp);
            statement.setString(5, alamat);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke dalam database!");
                
            }
            
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
        }
    }
}