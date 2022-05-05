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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import user.User;
import user.Admin;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Data {

    private static ArrayList<ArrayList<Long>> timeList = new ArrayList<ArrayList<Long>>();
    public static ArrayList<User> userList = new ArrayList<User>();

    public static void addUser(boolean isAdmin, String password, String username, double wage) {
        if (isAdmin) {
            userList.add(new Admin(password, username, wage));
        } else {
            userList.add(new User(password, username, wage));
        }
        timeList.add(new ArrayList<Long>());
        for (int i = 0; i < 7; i++) {
            timeList.get(userList.size() - 1).add(0L);
        }
    }

    public static void recordTime(int user, int day, Long time) {
        timeList.get(user).set(day, time + timeList.get(user).get(day));
    }

    public static Long getTime(int user, int day) {
        return timeList.get(user).get(day);
    }

    public static Long getTotalTime(int user) {
        Long total = 0l;
        for (int i = 0; i < 7; i++) {
            total += timeList.get(user).get(i);
        }
        return total;
    }

    // Serialize and save the data
    public static void saveData() {
        try {
            // Create the file
            FileOutputStream fileOut = new FileOutputStream("timeList.alex");
            // Create the object output stream
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Write the data
            out.writeObject(timeList);
            out.close();
            fileOut.close();
            // System.out.println("\nSerialization completed successfully...\n");
            // Catch any exceptions
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // repeat for userList
        try {
            FileOutputStream fileOut = new FileOutputStream("userList.alex");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(userList);
            out.close();
            fileOut.close();
            // System.out.println("\nSerialization completed successfully...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData() {
        Calendar cal = Calendar.getInstance();
        try {
            FileInputStream fileIn = new FileInputStream("timeList.alex");
            // Create the object input stream
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            // Read the data
            timeList = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
            // Catch any exceptions
        } catch (FileNotFoundException e) {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // repeat for userList
        try {
            FileInputStream fileIn = new FileInputStream("userList.alex");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            userList = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            for (int i = 0; i < userList.size(); i++) {
                for (int j = 0; j < 7; j++) {
                    timeList.get(i).set(j, 0l);
                }
            }
            System.out.println("Time data cleared for the new week!");
        }
    }
}