import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the toolshed! \n\n");
        Inventory store = new Inventory();
        mainMenu(store);


    }


    private static void mainMenu(Inventory inventory) {

        boolean loopSet = true;
        while (loopSet) {
            String answer = "";
            answer = getInput("What would you like to do today? \n"
                    + "1: Print Stock list \n"
                    + "2: Add new tool \n"
                    + "3: Delete tool\n"
                    + "4: Search for tool\n"
                    + "5: Generate Orders \n"
                    + "6: Display supplier List \n"
                    + "7: Quit \n");
            loopSet = caseSelector(answer, inventory);
        }
    }

    private static boolean caseSelector(String answer, Inventory inventory) {
        switch (answer) {
            case "1":
                System.out.println(inventory);
                promptForEnter();
                return true;

            case "2":
                answer = getInput("Input new tool info, fields separated by ; \n" +
                        "name; quantity; price; supplierID");
                parseNewTool(answer, inventory);
                promptForEnter();
                return true;

            case "3":
                answer = getInput("Input tool name or tool id #");
                inventory.deleteTool(answer);
                promptForEnter();
                return true;

            case "4":
                answer = getInput("Input tool name or tool id #");
                try {
                    int id = Integer.parseInt(answer);
                    inventory.toolSearch(id);
                } catch (Exception e) {
                    inventory.toolSearch(answer);
                }
                promptForEnter();
                return true;

            case "5":
                inventory.generateOrders();
                promptForEnter();
                return true;
            case "6":
                inventory.printSuppliers();
                promptForEnter();
                return true;
            case "7":
        }
        return false;
    }

    private static void parseNewTool(String ans, Inventory inventory) {
        String[] response = ans.split(";");
        for (int i = 0; i < response.length; i++) {
            response[i] = response[i].trim();
        }

        try {
            String name = response[0];
            int quantity = Integer.parseInt(response[1]);
            double price = Double.parseDouble(response[2]);
            int supplierID = Integer.parseInt(response[3]);
            inventory.addTool(name, quantity, price, supplierID);
            System.out.println("Tool added!");
        } catch (Exception e) {
            System.out.println("invalid input.");
        }
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        String answer = "";
        Scanner scan = new Scanner(System.in);
        answer = scan.nextLine();
        //scan.close();
        return answer;
    }


    private static void promptForEnter() {
        System.out.println("press ENTER to continue");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        //scan.close();
    }

}