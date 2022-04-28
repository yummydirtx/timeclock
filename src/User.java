public class User {
    // Each user should have a username and password
    private String username;
    private String password;

    public User() {
        this.username = "";
        this.password = "";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String oldPass, String password) {
        if (oldPass.equals(this.password)) {
            this.password = password;
        }
    }
}
