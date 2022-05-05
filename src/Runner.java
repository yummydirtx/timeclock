import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {
        // Control the main logic loop
        Data.loadData();
        boolean running = true;
        while (running) {
            // Ask if the user would like to login
            System.out.println("Would you like to login, or create a new user? (l) or (c) (q to exit)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("l")) {
                // Run the login
                LogIn.loginPrompt();
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
            if (LogIn.getCurrentUser() != -1 && running) {
                boolean loggedIn = true;
                while (loggedIn) {
                    // If the user is logged in, ask if they would like to do something else
                    System.out.println(
                            "What would you like to do? Clock (i)n, Clock (o)ut, (a)dmin console, or (l)ogout");
                    input = scanner.nextLine();
                    if (input.equals("i")) {
                        // Clock in
                        Clock.clockIn();
                    } else if (input.equals("o")) {
                        // Clock out
                        // Clock.clockOut();
                    } else if (input.equals("a")) {
                        // Run the admin console
                        AdminConsole.run();
                    } else if (input.equals("l")) {
                        // Logout
                        LogIn.logOut();
                        loggedIn = false;
                    } else {
                        // Invalid input
                        System.out.println("Invalid input.");
                    }
                }
            }
        }
        Data.saveData();
    }
}
