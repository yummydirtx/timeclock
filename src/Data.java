import java.io.File;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import android.content.Context;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Data {
    // Implementation courtesy of
    // https://gagandroid.blogspot.com/2015/03/read-or-write-serializable-arraylist.html
    public static void write(Context context, Object nameOfClassGetterSetter) {
        File directory = new File(context.getFilesDir().getAbsolutePath()
                + File.separator + "serlization");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename = "AnyName.srl";
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(directory
                    + File.separator + filename));
            out.writeObject(nameOfClass);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
