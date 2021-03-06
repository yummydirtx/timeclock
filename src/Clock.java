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

import java.util.Calendar;
import java.text.DecimalFormat;

// Manage time functions
public class Clock {
    // clock in
    public static double timeOut;

    public static void clockIn() {
        // if the user is not clocked in
        if (!Data.userList.get(LogIn.getCurrentUser()).isClockedIn()) {
            // clock in
            Data.userList.get(LogIn.getCurrentUser()).setClockedIn(true);
            // set the clock in time
            Data.userList.get(LogIn.getCurrentUser()).setClockInTime(System.currentTimeMillis());
            // print that the user has clocked in
            System.out.println("You have clocked in. Current time: " + java.time.LocalTime.now());
        } else {
            // print that the user is already clocked in
            System.out.println("You are already clocked in.");
        }

    }

    // clock out
    public static void clockOut() {
        DecimalFormat df = new DecimalFormat("0.00");
        Calendar calendar = Calendar.getInstance();
        // if the user is clocked in
        if (Data.userList.get(LogIn.getCurrentUser()).isClockedIn()) {
            // clock out
            Data.userList.get(LogIn.getCurrentUser()).setClockedIn(false);
            // record time worked to the correct day of the week in timeList
            Data.recordTime(LogIn.getCurrentUser(), calendar.get(Calendar.DAY_OF_WEEK) - 1, totalTime());
            // print that the user has clocked out

            System.out.println("You have clocked out. Current time: " + java.time.LocalTime.now() + ".\nTotal time: "
                    + df.format(totalTime() / 3600000.0) + " hours.");
        } else {
            // print that the user is already clocked out
            System.out.println("You are already clocked out.");
        }
    }

    private static long totalTime() {
        // end time subtracted from start time
        long total = System.currentTimeMillis() - Data.userList.get(LogIn.getCurrentUser()).getClockInTime();
        return total;
    }

    public static String totalTime(int user) {
        // end time subtracted from start time
        DecimalFormat df = new DecimalFormat("#.00");
        double total = (System.currentTimeMillis() - Data.userList.get(user).getClockInTime()) / 3600000.0;
        return df.format(total);
    }
}