public class Tool {

    private int id;
    private int quantity;
    private String name;
    private double price;
    private Supplier supplier;

    /**
     * Constructor
     * @param id
     * @param name
     * @param quantity
     * @param price
     * @param supplier
     */
    public Tool(int id, String name, int quantity, double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    /**
     * returns id
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * returns tool name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * returns tool price
     * @return
     */
    public double getPrice() {
        return price;
    }

    public String toString() {
        String st = "";
        st += "id: " + id + " name: " + name + ", " + String.valueOf(quantity) + " units, $" +
                String.valueOf(price) + " /ea";
        return st;
    }

    /**
     * Returns tool quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * increments tool quantity
     * negative increaments are allowed (reshelving stock)
     * @param increment
     */
    public void incrementQuantity(int increment){
        if (quantity - increment < 0) {
            System.out.println("Low stock warning! Only " + quantity + " items removed.");
        }
        quantity = ((quantity - increment) > 0) ? quantity - increment : 0;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
