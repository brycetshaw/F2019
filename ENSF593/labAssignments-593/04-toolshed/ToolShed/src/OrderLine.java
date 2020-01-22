/**
 * The type Order line.
 */
public class OrderLine {

 private Tool tool;
 private int quantity;

    /**
     * Instantiates a new Order line.
     *
     * @param tool     the tool
     * @param quantity the quantity
     */
    public OrderLine (Tool tool, int quantity){
        this.tool = tool;
        this.quantity = quantity;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return tool.getName();
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get tool tool.
     *
     * @return the tool
     */
    public Tool getTool(){
        return tool;
    }

    /**
     * Gets supplier name.
     *
     * @return the supplier name
     */
    public String getSupplierName() {
        return tool.getSupplier().getName();
    }
}
