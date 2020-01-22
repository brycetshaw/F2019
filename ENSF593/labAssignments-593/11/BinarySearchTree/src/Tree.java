import javax.imageio.IIOException;
import java.io.PrintWriter;

public class Tree {

    private Record head;

    public void add(Record record) {

        if (this.head == null) {
            this.head = record;
        } else {
            this.head.add(record);
        }
    }

    public Tree(){
        this.head = null;
    }

    public Record search(String lastName) {

        return TreeOps.binarySearch(head, lastName);
    }

    public void delete(String lastName) {
                head = TreeOps.delete(head, lastName);

    }

    public void printDepth(String filename) {

        try {

            PrintWriter writer = new PrintWriter(filename, "UTF-8");


            TreeOps.printDepth(writer, head);
            writer.close();

        } catch (Exception e) {
            System.out.println("IOEXCEPTION HAPPENED");
        }

    }

    public void printBreadth(String filename) {

        try {

            PrintWriter writer = new PrintWriter(filename, "UTF-8");


            writer.println(TreeOps.TreeString(head));
            writer.close();

        } catch (Exception e) {
            System.out.println("IOEXCEPTION HAPPENED");
        }
    }


}
