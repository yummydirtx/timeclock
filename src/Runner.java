/*
Copyright (c) 2022 Alex Frutkin and Hannah Behrend

This file is part of TimeClock.

TimeClock is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

TimeClock is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Foobar. If not, see <https://www.gnu.org/licenses/>.
*/

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws Exception {
        System.out.println(" _______ _____ _______ _______ _______         _____  _______ _     _\n" +
                "|      |   |  |  | |______ |       |      |     | |       |____/\n" +
                "    |    __|__ |  |  | |______ |_____  |_____ |_____| |_____  |    \\_\n" +
                "Created by Alex Frutkin and Hannah Behrend\n" +
                "Version 1.0 (5/5/2022) Licensed under GNU GPLv3+\n" +
                "Source code available at: https://github.com/yummydirtx/timeclock");
        // Control the main logic loop
        Data.loadData();
        boolean running = true;
        while (running) {
            // Ask if the user would like to login
            System.out.println("Would you like to login? (l) (q to exit)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("l")) {
                // Run the login
                LogIn.loginPrompt();
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
                            "What would you like to do? Clock (i)n, Clock (o)ut, (a)dmin console, (c)reate a user, or (l)ogout");
                    input = scanner.nextLine();
                    if (input.equals("i")) {
                        // Clock in
                        Clock.clockIn();
                    } else if (input.equals("o")) {
                        // Clock out
                        Clock.clockOut();
                    } else if (input.equals("a")) {
                        // Run the admin console
                        if (Data.userList.get(LogIn.getCurrentUser()).isAdmin()) {
                            AdminConsole.run();
                        } else {
                            System.out.println("You do not have permission to access this console.");
                        }
                    } else if (input.equals("l")) {
                        // Logout
                        LogIn.logOut();
                        loggedIn = false;
                    } else if (input.equals("c")) {
                        // Create a new user
                        LogIn.createUser();
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
