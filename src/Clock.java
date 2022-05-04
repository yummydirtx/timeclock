import java.util.Calendar;

// Manage time functions
public class Clock {
    // clock in
    public static double timeOut;

    public static void clockIn() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        // if the user is not clocked in
        if (!Data.userList.get(LogIn.getCurrentUser()).isClockedIn()) {
            // clock in
            Data.userList.get(LogIn.getCurrentUser()).setClockedIn(true);
            // set the clock in time
            Data.userList.get(LogIn.getCurrentUser()).setClockInTime(System.currentTimeMillis());
            //Data.userList.get(LogIn.getCurrentUser()).setClockInTime(System.currentTimeMillis());
            // print that the user has clocked in
            System.out.println("You have clocked in.");
        } else {
            // print that the user is already clocked in
            System.out.println("You are already clocked in.");
        }

    }

    // clock out
    public static void clockOut() {
        // if the user is clocked in
        if (Data.userList.get(LogIn.getCurrentUser()).isClockedIn()) {
            // clock out
            Data.userList.get(LogIn.getCurrentUser()).setClockedIn(false);
            // record time worked to the correct day of the week in timeList
            //Data.userList.get(LogIn.getCurrentUser()).setClockOutTime(System.currentTimeMillis());
            //Data.userList.get(LogIn.getCurrentUser()).setClockOutTime(System.currentTimeMillis());
            // print that the user has clocked out
            System.out.println("You have clocked out.");
        } else {
            // print that the user is already clocked out
            System.out.println("You are already clocked out.");
        }
    }

    public static double totalTime(double a) {
        //end time subtracted from start time
        double total = System.currentTimeMillis() - Data.userList.get(LogIn.getCurrentUser()).getClockInTime();
        return total;
        //return 0.0;
    }
}