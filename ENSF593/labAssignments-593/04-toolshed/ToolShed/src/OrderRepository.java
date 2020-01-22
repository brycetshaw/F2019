import java.util.ArrayList;

/**
 * The type Order repository.
 */
public class OrderRepository {
    private ArrayList<Order> orders = new ArrayList<Order>();


    /**
     * Add order.
     *
     * @param order the order
     */
    public void addOrder(Order order){
        orders.add(order);
        FileManager fileManager = new FileManager();
        fileManager.pushOrder(order.toString());
    }

    public String toString(){
        String st = "";
        for (Order o: orders) {
            st += o;
        }
        return st;
    }

    /**
     * Check number of items on order
     *
     * @param t tool
     * @return number of tools on order
     */
    public int checkOpenOrders(Tool t) {
        int onOrder = 0;
        for (Order o: orders) {
            onOrder += o.checkOpenOrders(t);
        }
        return onOrder;
    }
}
