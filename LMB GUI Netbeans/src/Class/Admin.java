package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import library_managebase_byteam6.Connector_db;

public class Admin extends User {
    private String nip;

    public Admin(String nip, String email, String alamat, String nohp, String gender, String username, String password, String siswaGuruId) {
        super(nip, email, alamat, nohp, gender, username, password);
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nisnnip) {
        this.nip = nip;
    }
    
 public void insertDataRegister(String nisnnip, String email, String alamat, String nohp, String username, String password, String regas, String gender, JTextField tf_nisnnip, JTextField tf_email, JTextField tf_alamat, JTextField tf_nohp, JTextField tf_username, JTextField pw_password, JComboBox cb_regas, JComboBox cb_gender) {
try{
        Connection conn = Connector_db.getConnection();
        
        String sql = "INSERT INTO register (nisnnip, email, alamat, nohp, username, password, regas, gender) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nisnnip);
        pst.setString(2, email);
        pst.setString(3, alamat);
        pst.setString(4, nohp);
        pst.setString(5, username);
        pst.setString(6, password);
        pst.setString(7, regas);   
        pst.setString(8, gender);
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
