package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import library_managebase_byteam6.Connector_db;

public class Peminjaman extends Buku {
    protected String peminjam;
    protected Date tanggalPinjam;
    protected Date tanggalTempo;

    public Peminjaman(String idbuku, String judul, String penulis, String penerbit, int stok) {
        super(idbuku, judul, penulis, penerbit, stok);
    }
    
    public void showDaftarBuku(JTable table) throws SQLException {
        try {
            Connection conn = Connector_db.getConnection();

            // Prepare SQL statement to retrieve data from the "buku" table
            String sql = "SELECT * FROM buku";
            PreparedStatement statement = conn.prepareStatement(sql);

            // Execute the SQL statement and get the result
            ResultSet rs = statement.executeQuery();

            // Remove previous data from the table
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // Add data rows to the table
            while (rs.next()) {
                Object[] rowData = new Object[5];
                rowData[0] = rs.getString("idbuku");
                rowData[1] = rs.getString("judul");
                rowData[2] = rs.getString("penulis");
                rowData[3] = rs.getString("penerbit");
                rowData[4] = rs.getInt("stok");
                model.addRow(rowData);
            }

            // Close the connections and statements
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }
    }

    // Getter and setter methods for peminjam
    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    // Getter and setter methods for tanggalPinjam
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    // Getter and setter methods for tanggalTempo
    public Date getTanggalTempo() {
        return tanggalTempo;
    }

    public void setTanggalTempo(Date tanggalTempo) {
        this.tanggalTempo = tanggalTempo;
    }
}
