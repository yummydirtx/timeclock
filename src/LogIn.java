import java.util.Scanner;

public class LogIn {
    // Records the current user
    private static int currentUser = -1;

    // Basic login function, validates the password to the username
    public static int logIn(int username, String password) {
        if (Data.userList.size() == 0) {
            System.out.println("There are no users. Creating a user...");
            Data.addUser(true, password);
            System.out.println("User created successfully!");
            System.out.println("Username: " + (Data.userList.size() - 1));
            System.out.println("Password: " + password);
            currentUser = 0;
            return 0;
        }
        if (username > Data.userList.size() - 1) {
            return -1;
        }
        if (Data.userList.get(username).validatePassword(password)) {
            currentUser = username;
            return 0;
        } else {
            return -1;
        }
    }

    public static void createUser() {
        Scanner scanner = new Scanner(System.in);
        boolean notAdmin = true;
        if (LogIn.getCurrentUser() != -1) {
            if (Data.userList.get(LogIn.getCurrentUser()).isAdmin()) {
                notAdmin = false;
            }
        }
        while (notAdmin) {
            System.out.println(
                    "To do this you must log in as an admin. (if there is no admin account then type in 0 for username and set the password to the one you'd like to be associated with the first admin) -1 to cancel");
            System.out.println("Enter your username: ");
            int username = scanner.nextInt();
            if (username == -1) {
                break;
            }
            System.out.println("Enter your password: ");
            String password = scanner.next();
            int result = LogIn.logIn(username, password);
            if (result == 0) {
                System.out.println("Logged in successfully!");
            } else {
                System.out.println("Incorrect username or password.");
            }
            notAdmin = !Data.userList.get(LogIn.getCurrentUser()).isAdmin();
        }
        if (Data.userList.get(LogIn.getCurrentUser()).isAdmin()) {
            System.out.println("Enter the password for the user you would like to create: ");
            String password = scanner.next();
            System.out.println("Is this user an admin? (y/n)");
            String admin = scanner.next();
            if (admin.equals("y")) {
                Data.addUser(true, password);
            } else {
                Data.addUser(false, password);
            }
            System.out.println("User created successfully!");
            System.out.println("Username: " + (Data.userList.size() - 1));
            System.out.println("Password: " + password);
        } else {
            System.out.println("You must log in as an admin to create a user.");
        }
    }

    // Logout function, sets currentUser to -1
    public static void logOut() {
        currentUser = -1;
    }

    // Getter for currentUser
    public static int getCurrentUser() {
        return currentUser;
    }
}
