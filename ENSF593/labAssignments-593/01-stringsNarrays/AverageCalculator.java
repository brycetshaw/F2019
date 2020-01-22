package ensf593lab1;

public class AverageCalculator {

    public static void main(String[] args) {
        double sum = 0;
        double average;
        System.out.print("The " + args.length + " numbers are: ");
        for (String var : args) {
            double currentArg = Double.parseDouble(var);
            sum += currentArg;
            System.out.printf("%.3f ", currentArg);
        }
        average = sum / args.length;
        System.out.printf("\nAnd their average is: %.3f\n", average);
    }

}
