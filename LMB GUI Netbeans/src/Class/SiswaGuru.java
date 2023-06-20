package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import library_managebase_byteam6.Connector_db;

public class SiswaGuru extends User {
    private String nisn;

    public SiswaGuru(String nisn, String email, String alamat, String nohp, String gender, String username, String password, String siswaGuruId) {
        super(nisn, email, alamat, nohp, gender, username, password);
        this.nisn = nisn;    
    }

    public String getNisnnip() {
        return nisn;
    }

    public void setNisnnip(String nisnnip) {
        this.nisn = nisn;
    }
    
    public void insertDataRegister(JTextField tf_nisnnip, JTextField tf_email, JTextField tf_alamat, JTextField tf_nohp, JTextField tf_username, JTextField pw_password, JComboBox cb_regas, JComboBox cb_gender) {
try{
        Connection conn = Connector_db.getConnection();
        
        String sql = "INSERT INTO register (nisnnip, email, alamat, nohp, username, password, regas, gender) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, tf_nisnnip.getText());
        pst.setString(2, tf_email.getText());
        pst.setString(3, tf_alamat.getText());
        pst.setString(4, tf_nohp.getText());
        pst.setString(5, tf_username.getText());
        pst.setString(6, pw_password.getText());
        pst.setString(7, cb_regas.getSelectedItem().toString());   
        pst.setString(8, cb_gender.getSelectedItem().toString());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Anda berhasil melakukan register!");
        tf_nisnnip.setText("");
        tf_email.setText("");
        tf_alamat.setText("");
        tf_nohp.setText("");
        tf_username.setText("");
        pw_password.setText("");
        cb_regas.setSelectedItem("");
        cb_gender.setSelectedItem("");
  
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }}
}



