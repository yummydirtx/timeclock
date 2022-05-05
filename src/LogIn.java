/*
    Copyright (c) 2022 Alex Frutkin and Hannah Behrend
    
    This file is part of TimeClock.

    TimeClock is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    TimeClock is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TimeClock.  If not, see <https://www.gnu.org/licenses/>.

*/

import java.util.Scanner;

public class LogIn {
    // Records the current user
    private static int currentUser = -1;

    public static void loginPrompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        int username = scanner.nextInt();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        int result = logIn(username, password);
        if (result == 0) {
            System.out.println("Logged in successfully!");
            System.out.println("Hello " + Data.userList.get(username).getUsername() + "!");
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    // Basic login function, validates the password to the username
    public static int logIn(int username, String password) {
        if (Data.userList.size() == 0) {
            System.out.println("There are no users. Creating a user...");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your wage:");
            double wage = scanner.nextDouble();
            Data.addUser(true, password, name, wage);
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
                return;
            }
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
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
            String password = scanner.nextLine();
            System.out.println("Is this user an admin? (y/n)");
            String admin = scanner.nextLine();
            System.out.println("What is this user's name?");
            String name = scanner.nextLine();
            System.out.println("What is this user's wage?");
            double wage = scanner.nextDouble();
            if (admin.equals("y")) {
                Data.addUser(true, password, name, wage);
            } else {
                Data.addUser(false, password, name, wage);
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
