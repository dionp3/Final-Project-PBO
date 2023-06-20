package Class;

import Class.Pengembalian;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import library_managebase_byteam6.Connector_db;

public class Pengembalian extends Peminjaman {
    private int jumlah;

    public Pengembalian(String idBuku, String judul, String penulis, String penerbit, int stok, String peminjam, Date tanggalPinjam, Date tanggalTempo, int jumlah) {
        super(idBuku, judul, penulis, penerbit, stok);
        this.peminjam = peminjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalTempo = tanggalTempo;
        this.jumlah = jumlah;
    }

    // Getter and setter methods for jumlah
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
 public void kembalikanBuku(String idBuku, int jumlah) {
    try {
        Connection conn = Connector_db.getConnection();
        // Mengecek stok buku yang tersedia
        String checkStokQuery = "SELECT * FROM buku WHERE idbuku = ?";
        PreparedStatement checkStokStatement = conn.prepareStatement(checkStokQuery);
        checkStokStatement.setString(1, idBuku);
        ResultSet stokResult = checkStokStatement.executeQuery();

        if (stokResult.next()) {
            int stok = stokResult.getInt("stok");

            // Mengupdate stok buku setelah pengembalian
            String updateStokQuery = "UPDATE buku SET stok = ? WHERE idbuku = ?";
            PreparedStatement updateStokStatement = conn.prepareStatement(updateStokQuery);
            updateStokStatement.setInt(1, stok + jumlah);
            updateStokStatement.setString(2, idBuku);
            updateStokStatement.executeUpdate();

//             Menghapus data peminjaman buku
            String deletePeminjamanQuery = "DELETE FROM peminjaman WHERE idbuku = ?";
            PreparedStatement deletePeminjamanStatement = conn.prepareStatement(deletePeminjamanQuery);
            deletePeminjamanStatement.setString(1, idBuku);
            deletePeminjamanStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Buku berhasil dikembalikan!");
        }

        // Menutup koneksi dan pernyataan SQL
        stokResult.close();
        checkStokStatement.close();
        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
    }
}  

public void showDatafromDB(JTable tabel_pengembalian) {
    try {
        Connection conn = Connector_db.getConnection();
        
        // Menyiapkan pernyataan SQL untuk mendapatkan data dari tabel
        String sql = "SELECT * FROM peminjaman";
        PreparedStatement statement = conn.prepareStatement(sql);

        // Menjalankan pernyataan SQL dan mendapatkan hasilnya
        ResultSet rs = statement.executeQuery();

        // Mengambil metadata hasil query
        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // Menghapus data sebelumnya dari tabel
        DefaultTableModel model = (DefaultTableModel) tabel_pengembalian.getModel();
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
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
    }
}}