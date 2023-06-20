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
//        public void showDatafromDB() {
//    try {
//        Connection conn = Connector_db.getConnection();
//        Statement statement = conn.createStatement();
//        String sql = "SELECT * FROM buku";
//
//        ResultSet rs = statement.executeQuery(sql);
//        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
//        DefaultTableModel model = (DefaultTableModel) tabel_buku.getModel();
//        int cols = rsmd.getColumnCount();
//
//        // Menghapus kolom yang ada pada tabel sebelumnya (jika ada)
//        model.setColumnCount(0);
//
//        // Menambahkan nama kolom ke model tabel
//        for (int i = 1; i <= cols; i++) {
//            model.addColumn(rsmd.getColumnName(i));
//        }
//
//        // Menambahkan data ke model tabel
//        while (rs.next()) {
//            Object[] row = new Object[cols];
//            for (int i = 1; i <= cols; i++) {
//                row[i - 1] = rs.getObject(i);
//            }
//            model.addRow(row);
//        }
//
//        statement.close();
//        conn.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e.getMessage());
//    }
//}
//    
//
//    // Menampilkan data dari database ke dalam tabel
//    public void showDataInTable() {
//        try {
//            Connection conn = Connector_db.getConnection();
//
//            // Menyiapkan pernyataan SQL untuk mendapatkan data dari tabel
//            String sql = "SELECT * FROM buku";
//            PreparedStatement statement = conn.prepareStatement(sql);
//
//            // Menjalankan pernyataan SQL dan mendapatkan hasilnya
//            ResultSet rs = statement.executeQuery();
//
//            // Mengambil metadata hasil query
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int columnCount = rsmd.getColumnCount();
//
//            // Menghapus data sebelumnya dari tabel
//            DefaultTableModel model = new DefaultTableModel();
//            model.setColumnCount(0);
//
//            // Menambahkan nama kolom ke model tabel
//            for (int i = 1; i <= columnCount; i++) {
//                model.addColumn(rsmd.getColumnName(i));
//            }
//
//            // Menambahkan data ke model tabel
//            while (rs.next()) {
//                Object[] rowData = new Object[columnCount];
//                for (int i = 0; i < columnCount; i++) {
//                    rowData[i] = rs.getObject(i + 1);
//                }
//                model.addRow(rowData);
//            }
//
//            // Menutup koneksi dan pernyataan SQL
//            rs.close();
//            statement.close();
//            conn.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
//        }
//    }}

//     Memasukkan data ke dalam database
//    public void insertDataToDB(String idbuku, String judul, String penulis, String penerbit, int stok) {
//        try {
//            Connection conn = Connector_db.getConnection();
//
//            String sql = "INSERT INTO buku (idbuku, judul, penulis, penerbit, stok) VALUES (?, ?, ?, ?, ?)";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, idbuku);
//            statement.setString(2, judul);
//            statement.setString(3, penulis);
//            statement.setString(4, penerbit);
//            statement.setInt(5, stok);
//
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke dalam database!");
//            }
//
//            statement.close();
//            conn.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
//        }
//    }
//}
