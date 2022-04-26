import java.nio.file.Files;
import java.nio.file.Paths;

public class FMan {
    private static String path = "clockdata.txt";
    private static String write = "testing testing";

    public static void writepath() {
        try {
            Files.write(Paths.get(path), write.getBytes());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
