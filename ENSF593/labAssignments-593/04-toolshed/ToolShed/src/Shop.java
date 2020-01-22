import java.util.ArrayList;

public class Shop {
    private SupplierList supplierList;
    private Inventory inventory;
    private OrderRepository orderRepository;

    /**
     * Constructor for shop. Populates suppliers and inventory from DB
     */
    public Shop() {
        FileManager fileManager = new FileManager();
        supplierList = fileManager.createSupplierList();
        inventory = fileManager.createInventory(supplierList);
        orderRepository = fileManager.createOrderRepository();
    }

    /**
     * returns inventory
     *
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Add tool from user. Also generates tool id.
     *
     * @param name
     * @param quantity
     * @param price
     * @param supplierID
     */
    public void addTool(String name, int quantity, double price, int supplierID) {
        inventory.addTool(name, quantity, price, supplierID, supplierList);
    }

    /**
     * Prints all suppliers
     */
    public void printSuppliers() {
        System.out.println(supplierList);
    }

    /**
     * checks low stock items, creates order and adds low stock items to it
     * the order gets taken and eventually written to DB
     *
     * @param lowNum
     */
    public void checkLowStock(int lowNum) {
        ArrayList<Tool> lowStockTools = inventory.lowStockItems(lowNum);

        boolean newOrder = (lowStockTools.size() == 0);
        for (Tool t : lowStockTools) {
            if (orderRepository.checkOpenOrders(t) > 50 - t.getQuantity()) {
                newOrder = true;
            }
        }

        if (newOrder) {
            return;
        }
        Order order = new Order();
        for (Tool t : lowStockTools) {
            if (50 - t.getQuantity() - orderRepository.checkOpenOrders(t) > 0) {
                OrderLine orderLine = new OrderLine(t, 50 - t.getQuantity() - orderRepository.checkOpenOrders(t));
                order.addOrder(orderLine);
            }
        }
        orderRepository.addOrder(order);
    }

    /**
     * prints all orders
     */
    public void printOrderRepository() {
        System.out.println(orderRepository);
    }
}
