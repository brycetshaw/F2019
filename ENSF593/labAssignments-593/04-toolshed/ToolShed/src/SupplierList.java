import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Supplier list.
 */
public class SupplierList {
    private ArrayList<Supplier> suppliers= new ArrayList<Supplier>();

    /**
     * Instantiates a new Supplier list.
     */
    public SupplierList(){
      //  ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        importDB();
    }

    /**
     * Supplier by id supplier.
     *
     * @param id the id
     * @return the supplier
     */
    public Supplier supplierByID(int id) {
        for (Supplier c : suppliers) {
            if (id == c.getID()) {
                return c;
            }
        }
        return null;
    }

    private void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    private void importDB(){
        FileManager fileManager = new FileManager();
        List<String> supplierDB =  fileManager.importDB("suppliers");
        for(int i = 0; i < supplierDB.size(); i++){
            this.suppliers.add(fileManager.createSupplierFromDbLine(supplierDB.get(i)));
        }
        //supplierDB.forEach(line -> addSupplier(fileManager.createSupplierFromDbLine(line)));
    }

    public String toString() {
        String st = "";
        for (Supplier s : suppliers) {
            st += "ID: " + s.getID() + ", Name: " + s.getName() +
                    ", Address: " + s.getAddress() + ", Contact: " + s.getContact() + "\n";
        }
        return st;
    }
}
