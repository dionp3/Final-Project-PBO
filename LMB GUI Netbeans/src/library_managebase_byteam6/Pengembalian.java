/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library_managebase_byteam6;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author USER
 */
public class Pengembalian extends javax.swing.JFrame {

    /**
     * Creates new form Pengembalian
     */
    public Pengembalian() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tf_idbuku = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pengembalian = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel_Peminjaman = new javax.swing.JLabel();
        jLabel_Pengembalian = new javax.swing.JLabel();
        jLabel_Buku = new javax.swing.JLabel();
        jLabel_Member = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        btn_update1 = new javax.swing.JButton();
        spinner_jmlh = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(197, 137, 64));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Library Manage Base", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Ink Free", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(250, 234, 177));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

        tf_idbuku.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(197, 137, 64));
        jLabel1.setText("Id Buku");

        btn_ok.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btn_ok.setForeground(new java.awt.Color(197, 137, 64));
        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        tabel_pengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Peminjam", "Id Buku", "Tanggal Pinjam", "Tanggal Tempo", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_pengembalian);

        jPanel4.setBackground(new java.awt.Color(197, 137, 64));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(250, 234, 177), java.awt.Color.white, new java.awt.Color(250, 234, 177)));

        jLabel_Peminjaman.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_Peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Peminjaman.setText("Peminjaman");
        jLabel_Peminjaman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_PeminjamanMouseClicked(evt);
            }
        });

        jLabel_Pengembalian.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_Pengembalian.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Pengembalian.setText("Pengembalian");
        jLabel_Pengembalian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_PengembalianMouseClicked(evt);
            }
        });

        jLabel_Buku.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_Buku.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Buku.setText("Buku");
        jLabel_Buku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BukuMouseClicked(evt);
            }
        });

        jLabel_Member.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel_Member.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Member.setText("Member");
        jLabel_Member.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Member.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_MemberMouseClicked(evt);
            }
        });

        btn_logout.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(197, 137, 64));
        btn_logout.setText("Logout");
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Member)
                    .addComponent(jLabel_Buku)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel_Pengembalian, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel_Peminjaman)
                        .addComponent(btn_logout, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel_Member)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Buku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Peminjaman)
                .addGap(12, 12, 12)
                .addComponent(jLabel_Pengembalian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout)
                .addGap(54, 54, 54))
        );

        btn_update1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btn_update1.setForeground(new java.awt.Color(197, 137, 64));
        btn_update1.setText("Show");
        btn_update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(197, 137, 64));
        jLabel6.setText("Jumlah");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update1)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_idbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinner_jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_idbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ok)
                            .addComponent(btn_update1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(spinner_jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void kembaliBuku(String idBuku, String peminjaman,  Date tanggalkembali, int jumlah) {
    try {
        // Mengganti dengan informasi koneksi database Anda
        String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
        String username = "root";
        String password = "ardhi@26";

        // Membuat koneksi ke database
        Connection conn = DriverManager.getConnection(url, username, password);

        // Mengecek stok buku yang tersedia
        String checkStokQuery = "SELECT * FROM buku WHERE idbuku = ?";
        PreparedStatement checkStokStatement = conn.prepareStatement(checkStokQuery);
        checkStokStatement.setString(2, idBuku);
        ResultSet stokResult = checkStokStatement.executeQuery();

        if (stokResult.next()) {
            int stok = stokResult.getInt("stok");

            if (stok > 0) {
                String updateStokQuery = "UPDATE buku SET stok = ? WHERE idbuku = ?";
                PreparedStatement updateStokStatement = conn.prepareStatement(updateStokQuery);
                updateStokStatement.setInt(1, stok + jumlah);
                updateStokStatement.setString(2, idBuku);
                updateStokStatement.executeUpdate();

                // Menambahkan data peminjaman ke tabel "peminjaman"
                String peminjamanQuery = "INSERT INTO peminjaman (tglkembali) VALUES (?)";
                PreparedStatement kembaliStatement = conn.prepareStatement(peminjamanQuery);
                kembaliStatement.setDate(6, new java.sql.Date(tanggalkembali.getTime()));
                kembaliStatement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Buku berhasil dipinjam!");
            } else {
                JOptionPane.showMessageDialog(this, "Maaf, stok buku habis!");
            }
        }

        // Menutup koneksi dan pernyataan SQL
        stokResult.close();
        checkStokStatement.close();
        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
    }
}


   
    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
       String idbuku = tf_idbuku.getText();
       int jumlah = (int) spinner_jmlh.getValue();
            kembalikanBuku(idbuku, jumlah);
      
    }//GEN-LAST:event_btn_okActionPerformed

    private void jLabel_PeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PeminjamanMouseClicked
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setVisible(true);
        peminjaman.pack();
        peminjaman.setLocationRelativeTo(null);
        peminjaman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_PeminjamanMouseClicked

    private void jLabel_PengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_PengembalianMouseClicked
        Pengembalian pengembalian = new Pengembalian();
        pengembalian.setVisible(true);
        pengembalian.pack();
        pengembalian.setLocationRelativeTo(null);
        pengembalian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_PengembalianMouseClicked

    private void jLabel_BukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BukuMouseClicked
        Buku buku = new Buku();
        buku.setVisible(true);
        buku.pack();
        buku.setLocationRelativeTo(null);
        buku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_BukuMouseClicked

    private void jLabel_MemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_MemberMouseClicked
        Member member = new Member();
        member.setVisible(true);
        member.pack();
        member.setLocationRelativeTo(null);
        member.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_MemberMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update1ActionPerformed
            showDatafromDB();
    }//GEN-LAST:event_btn_update1ActionPerformed
    
    public void kembalikanBuku(String idBuku, int jumlah) {
    try {
        // Mengganti dengan informasi koneksi database Anda
        String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
        String username = "root";
        String password = "ardhi@26";

        // Membuat koneksi ke database
        Connection conn = DriverManager.getConnection(url, username, password);

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

            JOptionPane.showMessageDialog(this, "Buku berhasil dikembalikan!");
        }

        // Menutup koneksi dan pernyataan SQL
        stokResult.close();
        checkStokStatement.close();
        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
    }
}

    public void showDatafromDB() {
    try {
        String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
        String username = "root";
        String password = "ardhi@26";

        
        Connection conn = DriverManager.getConnection(url, username, password);

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
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_update1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Buku;
    private javax.swing.JLabel jLabel_Member;
    private javax.swing.JLabel jLabel_Peminjaman;
    private javax.swing.JLabel jLabel_Pengembalian;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinner_jmlh;
    private javax.swing.JTable tabel_pengembalian;
    private javax.swing.JTextField tf_idbuku;
    // End of variables declaration//GEN-END:variables
}
