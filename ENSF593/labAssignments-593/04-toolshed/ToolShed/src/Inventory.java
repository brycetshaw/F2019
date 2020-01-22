import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Inventory.
 */
public class Inventory {
    private ArrayList<Tool> tools = new ArrayList<Tool>();

    /**
     * Instantiates a new Inventory.
     *
     * @param supplierList the supplier list
     */
    public Inventory(SupplierList supplierList){
        FileManager fileManager = new FileManager();
        List<String> toolDB =  fileManager.importDB("items");
        toolDB.forEach(line -> addTool(fileManager.createToolFromDbLine(line, supplierList)));
    }

    /**
     * Add tool.
     *
     * @param tool the tool
     */
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    /**
     * Add tool. generates tool id.
     *
     * @param name         the name
     * @param quantity     the quantity
     * @param price        the price
     * @param supplierID   the supplier id
     * @param supplierList the supplier list
     */
    public void addTool(String name, int quantity, double price, int supplierID, SupplierList supplierList){
        int id = generateToolID();
        Tool tool = new Tool(id, name, quantity, price, supplierList.supplierByID(supplierID));
        tools.add(tool);
    }


    /**
     * Delete tool.
     *
     * @param name the name
     */
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

    private boolean toolSearch (int id) {
        for (Tool c : tools) {
            if (id == c.getID()) {
                System.out.println(c);
                return true;
            }
        }
        System.out.println("Tool not found.");
        return false;
    }

    /**
     * Tool search boolean.
     *
     * @param name tool name or id
     * @return true if tool exists
     */
    public boolean toolSearch (String name) {

        try {
            int id = Integer.parseInt(name);
            toolSearch(id);
            return true;
        } catch (Exception e) {
            for (Tool c : tools) {
                if (name.equals(c.getName())) {
                    System.out.println(c);
                    return true;
                }
            }
        }
        System.out.println("Tool not found.");
        return false;
    }

    public String toString() {
        String st = "";
        for (Tool c : tools) {
            st += c + "\n";
        }
        return st;
    }

    /**
     * Low stock items array list.
     *
     * @param lowNum threshold for low stock
     * @return the array list
     */
    public ArrayList<Tool> lowStockItems(int lowNum) {
        ArrayList<Tool> lowStock = new ArrayList<Tool>();
        for (Tool c : tools) {
            if ((lowNum > c.getQuantity())) {
                lowStock.add(c);
            }
        }
        return lowStock;
    }

    /**
     * Decrease tool quantity.
     *
     * @param toolName  the tool name
     * @param increment the increment
     */
    public void decreaseToolQuantity(String toolName, int increment) {
        int index = getToolIndex(toolName);
        tools.get(index).incrementQuantity(increment);
    }
}
