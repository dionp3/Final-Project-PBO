// User class (base class for Admin, Member, Student, and Teacher)
public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Login method
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
