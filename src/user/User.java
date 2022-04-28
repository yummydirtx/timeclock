package user;

public class User {
    // Each user should have a password
    private String password;

    // Two basic constructors
    public User() {
        this.password = "";
    }

    public User(String username, String password) {
        this.password = password;
    }

    // Getters and setters, with validation for password

    public void setPassword(String oldPass, String password) {
        if (oldPass.equals(this.password)) {
            this.password = password;
        }
    }
}
