import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The type Order.
 */
public class Order {
    private int id;
    private String date;
    private ArrayList<OrderLine> orderlines = new ArrayList<OrderLine>();

    /**
     * Instantiates a new Order.
     */
    public Order() {
        this.id = generateOrderID();
        this.date = generateDate();
    }

    /**
     * Add order.
     *
     * @param orderLine the order line
     */
    public void addOrder(OrderLine orderLine) {
        orderlines.add(orderLine);
    }


    /**
     * Check open orders int.
     *
     * @param tool the tool
     * @return number of tools on order
     */
    public int checkOpenOrders(Tool tool){
        int onOrder = 0;
        for (OrderLine o: orderlines) {
            if(o.getTool() == tool){
                onOrder += o.getQuantity();
            }
        }
        return onOrder;
    }
    private int generateOrderID() {
        return (int) Math.floor(Math.random() * 10000);
    }

    private String generateDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        String st = buildHeader();
        st += buildBody();
        return st;
    }

    private String buildHeader() {
        String st = "";
        st += "ORDER ID:            " + id + "\n";
        st += "Date Ordered:        " + date;
        return st;
    }

    private String buildBody() {
        String st = "";
        String descriptionHead = "\nItem Description:    ";
        String amountHead = "\nAmount Ordered:      ";
        String supplierHead = "\nSupplier:            ";
        for (OrderLine c : orderlines) {
            st += descriptionHead + c.getName();
            st += amountHead + String.valueOf(c.getQuantity());
            st += supplierHead + c.getSupplierName() + "\n";
        }
        st += "**********************************************************************\n";
        return st;
    }
}
