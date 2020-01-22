import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the toolshed! \n");
        Shop shop = new Shop();
        mainMenu(shop);
    }


    private static void mainMenu(Shop shop) {

        boolean loopSet = true;
        while (loopSet) {
            //Check inventory numbers
            shop.checkLowStock(40);
            String answer = "";
            answer = getInput("What would you like to do today? \n"
                    + "1: Print Stock list \n"
                    + "2: Add new tool \n"
                    + "3: Search for tool (delete / view / update quantity)\n"
                    + "4: Display Orders \n"
                    + "5: Display supplier List \n"
                    + "7: Quit \n");
            loopSet = caseSelector(answer, shop);
        }
    }

    private static boolean caseSelector(String answer, Shop shop) {
        switch (answer) {
            case "1":
                System.out.println(shop.getInventory());
                promptForEnter();
                return true;

            case "2":
                answer = getInput("Input new tool info, fields separated by ; \n" +
                        "name; quantity; price; supplierID");
                parseNewTool(answer, shop);
                promptForEnter();
                return true;

            case "3":
                answer = getInput("Input tool name or tool id #");
                if (shop.getInventory().toolSearch(answer)) {
                    toolSearchMenu(answer, shop);
                }
                return true;

            case "4":
                shop.printOrderRepository();
                promptForEnter();
                return true;

            case "5":
                shop.printSuppliers();
                promptForEnter();
                return true;
            case "6":

            case "7":
        }
        return false;
    }

    private static void toolSearchMenu(String toolName, Shop shop) {
        String answer = getInput("What would you like to do with the tool? \n"
                + "1: Decrease Quantity \n"
                + "2: Delete tool \n"
                + "3: Nothing, just checking. \n");
        switch (answer) {
            case "1":
                int increment = Integer.parseInt(getInput("Decrease stock by how many?"));
                shop.getInventory().decreaseToolQuantity(toolName, increment);
                shop.getInventory().toolSearch(toolName);
                promptForEnter();
                return;
            case "2":
                shop.getInventory().deleteTool(toolName);
                promptForEnter();
            case "3":
        }
        return;
    }

    private static void parseNewTool(String ans, Shop shop) {
        String[] response = ans.split(";");
        for (int i = 0; i < response.length; i++) {
            response[i] = response[i].trim();
        }
        try {
            String name = response[0];
            int quantity = Integer.parseInt(response[1]);
            double price = Double.parseDouble(response[2]);
            int supplierID = Integer.parseInt(response[3]);
            shop.addTool(name, quantity, price, supplierID);
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

    private static int getInputInt(String prompt) {
        Scanner scan = new Scanner(System.in);
        while(true){
            try {
                System.out.println(prompt);
                String answer = "";
                answer = scan.nextLine();
                return Integer.parseInt(answer);
            } catch (Exception e){
                System.out.println("Input must be an integer. Try again.");
            }
        }
        //scan.close();
    }


    private static void promptForEnter() {
        System.out.println("press ENTER to continue");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        //scan.close();
    }
}