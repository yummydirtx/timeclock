//import java.io.File;
//import java.io.ObjectOutput;
//import java.io.ObjectOutputStream;
//import org.omg.CORBA.Context;

import user.User;
import user.Admin;

import java.util.ArrayList;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.FileNotFoundException;

public class Data {

    private static ArrayList<ArrayList<Double>> timeList = new ArrayList<ArrayList<Double>>();
    public static ArrayList<User> userList = new ArrayList<User>();

    public static void addUser(boolean isAdmin, String password) {
        if (isAdmin) {
            userList.add(new Admin(password));
        } else {
            userList.add(new User(password));
        }
        timeList.add(new ArrayList<Double>(7));
    }

    public static void recordTime(int user, int day, Double time) {
        timeList.get(user).set(day, time);
    }

    public static Double getTime(int user, int day) {
        return timeList.get(user).get(day);
    }

    public static Double getTotalTime(int user) {
        Double total = 0.0;
        for (int i = 0; i < 7; i++) {
            total += timeList.get(user).get(i);
        }
        return total;
    }
    /*
     * todo
     * // Implementation courtesy of
     * //
     * https://gagandroid.blogspot.com/2015/03/read-or-write-serializable-arraylist.
     * html
     * public static void write(Context context, Object nameOfClassGetterSetter) {
     * File directory = new File(context.getFilesDir().getAbsolutePath()
     * + File.separator + "serlization");
     * if (!directory.exists()) {
     * directory.mkdirs();
     * }
     * 
     * String filename = "AnyName.srl";
     * ObjectOutput out = null;
     * 
     * try {
     * out = new ObjectOutputStream(new FileOutputStream(directory
     * + File.separator + filename));
     * out.writeObject(nameOfClass);
     * out.close();
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     */
}