import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {
    private ArrayList<Tool> tools;
    private ArrayList<Supplier> suppliers;



    public Inventory(){
        //call the getters for tools, suppliers
        this.suppliers = importSupplierDB();
        this.tools = importToolDB();
    }

    public void addTool(String name, int quantity, double price, int supplierID) throws IllegalAccessException {
        int id = generateToolID();
        Supplier supplier = supplierByID(supplierID);
        if (supplier == null){
            throw new IllegalAccessException("Invalid supplier number");
        }
        Tool tool = new Tool(id, name, quantity, price, supplier);
        this.tools.add(tool);
    }

    public void deleteTool(String name){
        int index = getToolIndex(name);

        if ((index != -999)) {
            System.out.println(tools.get(index) + " was removed.");
            tools.remove(index);
            return;
        }
        System.out.println("Invalid Input.");
    }

    private int getToolIndex(String name) {

        try {
            int id = Integer.parseInt(name);
            for(int i = 0; i < tools.size(); i++){
                if ((id == tools.get(i).getID())) {
                    return i;
                }
            }

        } catch (Exception e) {
            for(int i = 0; i < tools.size(); i++){
                if ((name.equals(tools.get(i).getName()))) {
                    return i;
                }
            }
        }
        return -999;
    }

    private int generateToolID(){
        int id = 0;
        for (Tool c : tools) {
            if (id < c.getID()) {
                id = c.getID() + 1;
            }
        }
        return id;
    }

    public void toolSearch (int id) {
        for (Tool c : tools) {
            if (id == c.getID()) {
                System.out.println(c);
                return;
            }
        }

        System.out.println("Tool not found.");
    }

    public void toolSearch (String name) {
        for (Tool c : tools) {
            if (name == c.getName()) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Tool not found.");
    }

    private Supplier supplierByID (int id) {
        for (Supplier c : suppliers) {
            if (id == c.getID()) {
                return c;
            }
        }
        return null;
    }

    private ArrayList<Tool> importToolDB() {
        ArrayList<Tool> tools = new ArrayList<Tool>();
        List<String> toolDB = readDatabase("items");
        toolDB.forEach(line -> addToolFromDB(line, tools));
        return tools;
    }

    private void addToolFromDB(String importString, ArrayList<Tool> tools) {
        String[] toolInfo= importString.split(";");
        int id = Integer.parseInt(toolInfo[0]);
        String name = toolInfo[1];
        int quantity =Integer.parseInt(toolInfo[2]);
        double price = Double.parseDouble(toolInfo[3]);
        int supplierID = Integer.parseInt(toolInfo[4]);
        Tool tool = new Tool(id, name, quantity, price, supplierByID(supplierID));
        tools.add(tool);
    }

    private ArrayList<Supplier> importSupplierDB(){
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        List<String> supplierDB = readDatabase("suppliers");
        supplierDB.forEach(line -> addSupplierFromDB(line, suppliers));
        return suppliers;
    }

    private void addSupplierFromDB(String importString, ArrayList<Supplier> suppliers) {

        String[] supplierInfo = importString.split(";");
        int id = Integer.parseInt(supplierInfo[0]);
        String name = supplierInfo[1];
        String address =supplierInfo[2];
        String contact = supplierInfo[3];
        Supplier supplier = new Supplier(id, name, address, contact);
        suppliers.add(supplier);
    }

    private List readDatabase(String file){
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

    public String toString() {
        String st = "";
        for (Tool c : tools) {
            st += c + "\n";
        }
        return st;
    }
    private ArrayList<Tool> lowStockItems(int lowNum) {
        ArrayList<Tool> lowStock = new ArrayList<Tool>();
        for (Tool c : tools) {
            if ((lowNum > c.getQuantity())) {
                lowStock.add(c);
            }
        }
        return lowStock;

    }

    private int generateOrderID(){
        int id = (int) Math.floor(Math.random()*10000);
        return id;
    }

    private String generateDate(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void generateOrders(){
        ArrayList<Tool> lowStock = lowStockItems(40);
        int id = generateOrderID();
        String date = generateDate();
        String line = "**********************************************************************\n";
        String st = "ORDER ID:            " + id + "\n";
        st +=       "Date Ordered:        " + date;
        String descriptionHead = "\nItem Description:    ";
        String amountHead =  "\nAmount Ordered:      ";
        String supplierHead = "\nSupplier:            ";
        for (Tool c: lowStock) {
            st += descriptionHead + c.getName();
            st += amountHead + String.valueOf(50 - c.getQuantity());
            st += supplierHead + c.getSupplier().getName() +"\n";
        }
        st += line;
        pushOrder(st);
    }

    private void pushOrder(String order) {
        System.out.println("Writing order to database:\n" + order);
        writeDatabase("orders", order);

    }

    private String filePath(String file){
        String directory = System.getProperty("user.home");
        String folder = "toolshed";
        String fileName = file + ".txt";
        String absolutePath = directory + File.separator  + folder + File.separator + fileName;
        return absolutePath;
    }
    private void writeDatabase(String file, String order){
        file = filePath(file);
        File f = new File(file);
        if (!(f.exists())) {
            order = "**********************************************************************\n" + order;
        }

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(order);
            fileWriter.close();
            System.out.println("\n Write success!");
        } catch (IOException e) {
            System.out.println("Database write error! \n" + e);
        }
    }

    public void printSuppliers() {
        for (Supplier s: suppliers) {
            System.out.println("ID: " + s.getID() + ", Name: " + s.getName() +
                    ", Address: " + s.getAddress() + ", Contact: " + s.getContact());
        }
    }
}
