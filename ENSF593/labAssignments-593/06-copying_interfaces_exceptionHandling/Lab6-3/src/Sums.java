
import java.io.*;

public class Sums {

    public static void sum(BufferedReader in) {
        // takes a sequence of integers as inputs, and outputs their sum

        int s, nextInt;
        s = 0;

        System.out.println("Please input the sequence of integers to sum, terminated by a 0");

        nextInt = getNextInt(in);
        //Read next datum in input. An integer is expected

        while (nextInt != 0) {
            s = s + nextInt;
            nextInt = getNextInt(in);
        }
        System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //"in" will receive data from the standard input stream
        String c;

        System.out.print("Do you wish to calculate a sum?");

        while (responseYesNo(in)) {
            sum(in);
            System.out.print("Do you wish to calculate a sum?");
        }
        System.out.println("Goodbye");
    }

    private static int getNextInt(BufferedReader in) {
        while (true) {
            try {
                return Integer.parseInt(in.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please reenter.");
            } catch (IOException e) {
                System.out.println("IOException of some kind. Try Again?");
            } catch (Exception e) {
                System.out.println("Unknown error. Try again, and good luck.");
            }
        }
    }

    private static boolean responseYesNo(BufferedReader in) {
        String c = "";
        System.out.print(" (y/n)\n");
        while (true) {
            try {
                c = in.readLine();
                if (!c.equals("y") && !c.equals("n")) {
                    throw new InvalidAnswer();
                }
                if (c.equals("y")) {
                    return true;
                }
                return false;
            } catch (InvalidAnswer e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO exception. Try better inputs.");
            }
        }
    }
}