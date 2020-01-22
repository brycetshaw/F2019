import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private DataBase dataBase;
    private BinSearchTree tree= new BinSearchTree();

    public void addInputFile(String fileName) {
        this.dataBase.importDataBase(fileName);
        List<String> rawData = dataBase.getRawData();

        for (String line : rawData) {

            line = line.replaceAll("( )+", " ").strip();
            String[] thisLine = line.split(" ");
            for(int i = 0; i < 4; i++){
                thisLine[i] = thisLine[i].strip();
            }
            insert(thisLine[0], thisLine[1], thisLine[2], thisLine[3]);
        }
    }

    public void addDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public String getData(String flag) {
        StringWriter out = new StringWriter();
        PrintWriter writer = new PrintWriter(out);
        try {
            if(flag.equals("*")){
                tree.print_tree(tree.root, writer);
            } else {
                writer.println(tree.find(tree.root,flag).toString());
            }

        } catch (IOException e) {
            writer.println("Database error \n" + e);
        }
        return out.toString();
    }


    public void insert(String id, String faculty, String major, String year) {
        tree.insert(id, faculty, major, year);
    }

    public String find(String id){
        Node node = tree.find(tree.root,id);

        if (node != null){
            return node.toString();
        }
        return "Record not found.";
    }

}