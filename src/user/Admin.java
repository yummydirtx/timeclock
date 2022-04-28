package user;

public class Admin extends User {
    // Constructor
    public Admin(String password) {
        super(password);
    }

    // Override isAdmin to return true
    public boolean isAdmin() {
        return true;
    }
}
