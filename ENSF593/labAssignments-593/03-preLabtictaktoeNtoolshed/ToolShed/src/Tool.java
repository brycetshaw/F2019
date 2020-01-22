public class Tool {
    private int id;
    int quantity;
    private String name;
    private double price;
    private Supplier supplier;

    public  Tool(int id, String name, int quantity, double price, Supplier supplier){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    public int getID() {
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        String st = "";
        st += name + ", " + String.valueOf(quantity)+ " units, $" +
                String.valueOf(price) + " /ea";
        return st;
    }

    public int getQuantity() {
        return quantity;
    }
    public Supplier getSupplier(){
        return supplier;
    }
}
