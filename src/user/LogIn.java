package user;

public class LogIn {
    public static int logIn(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return 0;
        } else if (username.equals("user") && password.equals("user")) {
            return 1;
        } else {
            return -1;
        }
    }
}
