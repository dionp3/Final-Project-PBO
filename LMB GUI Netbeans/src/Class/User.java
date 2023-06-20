package Class;

public class User {
    private String nisnnip;
    private String email;
    private String alamat;
    private String nohp;
    private String gender;
    private String username;
    private String password;

    public User(String nisnnip, String email, String alamat, String nohp, String gender, String username, String password) {
        this.nisnnip = nisnnip;
        this.email = email;
        this.alamat = alamat;
        this.nohp = nohp;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    // Getter methods
    public String getNisnNip() {
        return nisnnip;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoHp() {
        return nohp;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter methods
    public void setNisnNip(String nisnnip) {
        this.nisnnip = nisnnip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoHp(String nohp) {
        this.nohp = nohp;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
