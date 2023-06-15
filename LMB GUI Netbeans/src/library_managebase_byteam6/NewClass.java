import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class NewClass extends JFrame {
    private JTable table;

    public NewClass() {
        setTitle("Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat model tabel default
        DefaultTableModel model = new DefaultTableModel();

        // Membuat objek JTable dengan model tabel default
        table = new JTable(model);

        // Menambahkan JTable ke JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Menambahkan JScrollPane ke frame
        add(scrollPane);

        pack();
        setVisible(true);

        // Mengisi data tabel dari database
        loadDataFromDB(model);
    }

    private void loadDataFromDB(DefaultTableModel model) {
        try {
            // Mengganti dengan informasi koneksi database Anda
            String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
            String username = "root";
            String password = "ardhi@26";

            // Membuat koneksi ke database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Membuat pernyataan SQL untuk mengambil data dari tabel
            String sql = "SELECT * FROM buku";
            Statement statement = conn.createStatement();

            // Menjalankan pernyataan SQL dan mendapatkan hasilnya
            ResultSet resultSet = statement.executeQuery(sql);

            // Mengambil metadata hasil query
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Mendapatkan jumlah kolom dalam hasil query
            int columnCount = metaData.getColumnCount();

            // Mengambil nama kolom dan menambahkannya ke model tabel
            for (int column = 1; column <= columnCount; column++) {
                model.addColumn(metaData.getColumnLabel(column));
            }

            // Mengambil data baris dari hasil query dan menambahkannya ke model tabel
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = resultSet.getObject(column);
                }
                model.addRow(row);
            }

            // Menutup koneksi dan pernyataan SQL
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NewClass();
            }
        });
    }
}
