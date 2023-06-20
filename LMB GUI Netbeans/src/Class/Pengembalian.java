/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Date;

/**
 *
 * @author Team 6
 */
public class Pengembalian extends Buku {
    protected String peminjam;
    protected Date tanggalpinjam;
    protected Date tanggaltempo;
    protected int jumlah;
    
    public Pengembalian(String idbuku, String judul, String penulis,String penerbit, int stok) {
        super("idbuku", "judul", "penulis", "penerbit", 0);
    }
    
    public String getPeminjam() {
        return this.peminjam;
    }
    
    public void setPeminjam(String peminjam){
        this.peminjam = peminjam;
    }
    
    public Date getTanggalpinjam() {
        return this.tanggalpinjam;
    }
    
    public void setTanggalpeminjam(Date tanggalpinjam){
        this.tanggalpinjam = tanggalpinjam;
    }
    
    public Date getTanggaltempo() {
        return this.tanggaltempo;
    }
    
    public void setTanggaltempo(Date tanggaltempo){
        this.tanggaltempo = tanggaltempo;
    }
    
    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
