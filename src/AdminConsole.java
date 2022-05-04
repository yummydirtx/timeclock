import java.util.Scanner;
import dnl.utils.text.table.TextTable;

public class AdminConsole {
    public static void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "What would you like to do? (c)hange a user's time, (s)how who's currently on the clock, (l)ist all users, or (q)uit");
            String input = scanner.nextLine();
            if (input.equals("c")) {
                // Change a user's time
                System.out.println("Enter the user's username: ");
                int username = scanner.nextInt();
                System.out.println("Enter the user's new time: ");
                Long time = scanner.nextLong();
                Data.recordTime(username, 1, time);
            } else if (input.equals("s")) {
                // Show who's currently on the clock
                System.out.println("Currently on the clock: ");
                for (int i = 0; i < Data.userList.size(); i++) {
                    if (Data.userList.get(i).isClockedIn()) {
                        System.out.println(i + " - " + Data.userList.get(i).getUsername());
                    }
                }
            } else if (input.equals("l")) {
                // List all users
                System.out.println("Users: ");
                for (int i = 0; i < Data.userList.size(); i++) {
                    System.out.println(i + " - " + Data.userList.get(i).getUsername());
                }
            } else if (input.equals("q")) {
                // Quit
                return;
            } else {
                // Invalid input
                System.out.println("Invalid input.");
            }
        }
    }
}
