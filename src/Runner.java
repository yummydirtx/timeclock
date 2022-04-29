import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {
        // Control the main logic loop
        boolean running = true;
        while (running) {
            // Ask if the user would like to login
            System.out.println("Would you like to login, or create a new user? (l) or (c) (q to exit)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("l")) {
                // Run the login
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
                // Create a new user if current user is an admin
                LogIn.createUser();
            } else if (input.equals("q")) {
                // Exit the program
                running = false;
            } else {
                // Invalid input
                System.out.println("Invalid input.");
            }
        }
    }
}
