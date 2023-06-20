/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import library_managebase_byteam6.Connector_db;

/**
 *
 * @author USER
 */
public class Member {
    protected String iduser;
    protected String nama;
    protected String nisn;
    protected String nohp;
    protected String alamat;
    
    public Member (String iduser, String nama, String nisn, String nohp, String alamat){
        this.iduser = iduser;
        this.nama = nama;
        this.nisn = nisn;
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
    
    public String getNisn(){
        return this.nisn; 
    }
    
    public void setNisn(String nisn) {
        this.nisn = nisn;
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
    
    public void insertDatatoDB(String idmember, String nama, String nisn, String nohp, String alamat) {
        try {
            Connection conn = Connector_db.getConnection();
            
            String sql = "INSERT INTO member (idmember, nama, nisn, nohp, alamat) VALUES (?, ?, ? ,? ,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idmember);
            statement.setString(2, nama);
            statement.setString(3, nisn);
            statement.setString(4, nohp);
            statement.setString(5, alamat);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke dalam database!");     
            }
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }
    }
}
