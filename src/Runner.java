import java.util.Scanner;

import user.LogIn;

public class Runner {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        int result = LogIn.logIn(username, password);
        if (result == 0) {
            System.out.println("You are logged in as admin");
        } else if (result == 1) {
            System.out.println("You are logged in as user");
        } else {
            System.out.println("Invalid username or password");
        }
    }
}
