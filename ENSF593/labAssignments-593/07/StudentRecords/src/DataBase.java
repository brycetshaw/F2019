import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    List<String> rawData;

    public DataBase() {

    }

    public void importDataBase(String file){
        rawData = readDatabase(file);
    }

    private List readDatabase(String file) {
        file = filePath(file);
        Path path = Paths.get(file);

        try {
            List<String> list = Files.readAllLines(path);
            return list;
        } catch (IOException e) {
            // exception handling
            System.out.println("Database error:" + file);
        }
        return null;
    }

    private String filePath(String file) {
        String directory = System.getProperty("user.home");
        String folder = "studentRegistration";
        String fileName = file + "";
        return directory + File.separator + folder + File.separator + fileName;
    }

    public String getData(String flag) {
        String st = "";
        if (flag.equals("*")) {
            for (String s: rawData) {
                st += s + "\n";
            }
        }
        return st;
    }


    public List<String> getRawData() {
        return rawData;
    }
}
