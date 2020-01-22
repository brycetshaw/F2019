import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * The type File manager.
 */
public class FileManager {

    /**
     * Create supplier list supplier list.
     *
     * @return the supplier list
     */
    public SupplierList createSupplierList() {
        SupplierList supplierList = new SupplierList();
        return supplierList;
    }

    /**
     * Create inventory inventory.
     *
     * @param supplierList the supplier list
     * @return the inventory
     */
    public Inventory createInventory(SupplierList supplierList) {
        Inventory inventory = new Inventory(supplierList);
        return inventory;
    }

    /**
     * Create order repository order repository.
     *
     * @return the order repository
     */
    public OrderRepository createOrderRepository() {
        OrderRepository orderRepository = new OrderRepository();
        return orderRepository;
    }

    /**
     * Import db list.
     *
     * @param file the file
     * @return the list
     */
    public List<String> importDB(String file) {
        List<String> toolDB = readDatabase(file);
        return toolDB;
    }

    /**
     * Create supplier from db line supplier.
     *
     * @param importString the import string
     * @return the supplier
     */
    public Supplier createSupplierFromDbLine(String importString) {
        String[] supplierInfo = importString.split(";");
        int id = Integer.parseInt(supplierInfo[0]);
        String name = supplierInfo[1];
        String address = supplierInfo[2];
        String contact = supplierInfo[3];
        Supplier supplier = new Supplier(id, name, address, contact);
        return supplier;
    }

    /**
     * Create tool from db line tool.
     *
     * @param importString the import string
     * @param supplierList the supplier list
     * @return the tool
     */
    public Tool createToolFromDbLine(String importString, SupplierList supplierList) {
        String[] toolInfo = importString.split(";");
        int id = Integer.parseInt(toolInfo[0]);
        String name = toolInfo[1];
        int quantity = Integer.parseInt(toolInfo[2]);
        double price = Double.parseDouble(toolInfo[3]);
        int supplierID = Integer.parseInt(toolInfo[4]);
        Tool tool = new Tool(id, name, quantity, price, supplierList.supplierByID(supplierID));
        return tool;
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
        String folder = "toolshed";
        String fileName = file + ".txt";
        return directory + File.separator + folder + File.separator + fileName;
    }


    private void writeDatabase(String file, String order) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(order);
            fileWriter.close();
            System.out.println("Placed a new order!");
        } catch (IOException e) {
            System.out.println("Database write error! \n" + e);
        }
    }

    /**
     * Push order.
     *
     * @param order the order
     */
    public void pushOrder(String order) {
        String file = filePath("orders");
        writeDatabase(file, order);
    }
}
