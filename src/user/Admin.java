package user;

public class Admin extends User {
    // Constructor
    public Admin(String password, String username, double wage) {
        super(password, username, wage);
    }

    // Override isAdmin to return true
    public boolean isAdmin() {
        return true;
    }
}
