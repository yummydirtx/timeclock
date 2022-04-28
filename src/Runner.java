import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {
        System.out.println("Would you like to login, or create a new user? (l) or (c)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("l")) {
            System.out.println("Enter your username: ");
            int username = scanner.nextInt();
            System.out.println("Enter your password: ");
            String password = scanner.next();
            int result = LogIn.logIn(username, password);
            if (result == 0) {
                System.out.println("Logged in successfully!");
            } else {
                System.out.println("Incorrect username or password.");
            }
        } else if (input.equals("c")) {
            while (!Data.userList.get(LogIn.getCurrentUser()).isAdmin()) {
                System.out.println(
                        "To do this you must log in as an admin. (if there is no admin account then type in 0 for both fields) -1 to cancel");
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
            } else {
                System.out.println("You must log in as an admin to create a user.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}
