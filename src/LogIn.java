public class LogIn {
    // Records the current user
    private static int currentUser = -1;

    // Basic login function, validates the password to the username
    public static int logIn(int username, String password) {
        if (Data.userList.size() == 0) {
            System.out.println("There are no users. Creating a user...");
            Data.addUser(true, password);
            System.out.println("User created successfully!");
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

    // Logout function, sets currentUser to -1
    public static void logOut() {
        currentUser = -1;
    }

    // Getter for currentUser
    public static int getCurrentUser() {
        return currentUser;
    }
}
