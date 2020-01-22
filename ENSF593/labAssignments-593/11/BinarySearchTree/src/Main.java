import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;
        String output1;
        String output2;
        Tree tree;


        try {
            input = args[0];
            output1 = args[1];
            output2 = args[2];
            tree = TreeOps.buildTree(input);

            tree.delete("Black");
            tree.delete("LaPorte");
            tree.delete("McKay");

            tree.printDepth(output1);
            System.out.println("\n");
            tree.printBreadth(output2);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("There was CDL read error. Be better. Type 3 correct file names.");
        } catch (FileNotFoundException f) {
            System.out.println("file not found." + f.getMessage());
        }
    }

}
