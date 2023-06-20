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
public class Pengembalian extends Peminjaman {
    protected String idbuku;
    protected int jumlah;
    
    public Pengembalian(String peminjam, Date tanggalPinjam, Date tanggalTempo) {
        super(peminjam, tanggalPinjam, tanggalTempo);
    }
    
    public String getIdbuku() {
        return this.idbuku;
    }
    
    public void setIdbuku(String idbuku){
        this.idbuku = idbuku;
    }
    
    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
