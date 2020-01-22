import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Exercise1 {

    public static void main(String[] args) {
        try {

            String order;
            int size;
            String algorithm;
            String outputFile;

            if (args.length == 4) {
                order = args[0];

                size = Integer.parseInt(args[1]);
                algorithm = args[2];
                outputFile = args[3];

                int[] array = buildArray(order, size);
                long totalTime = initAnalysis(array, algorithm, outputFile);

                logResult(order, size, algorithm, totalTime);

            } else {

                outputFile = "test.txt";
                String[] algorithms = {"quick", "insertion", "merge", "bubble"};
                int[] sizes = {10, 100, 1000, 10000,100000,  1000000};
                String[] orders = {"ascending", "descending", "random"};

                for (int i = 0; i < 6; i++) {
                    size = sizes[i];

                    for (int j = 0; j < 3; j++) {
                        order = orders[j];

                        for (int k = 0; k < 4; k++) {
                            algorithm = algorithms[k];

                            int[] array = buildArray(order, size);
                            System.out.println("Starting: " + size + " " + order + " " + algorithm);
                            try {
                                long totalTime = initAnalysis(array, algorithm, outputFile);

                                logResult(order, size, algorithm, totalTime);
                            } catch (Exception e) {
                                System.out.println(size + " " + order + " " + algorithm + "Failed.");
                            }


                        }
                    }
                }
            }


        } catch (Exception e) {
            System.out.println("Input error...");
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
    }

    private static void logResult(String order, int size, String algorithm, long totalTime) {
        String directory = System.getProperty("user.dir") + "/../";
        String outputFile = directory + "log.txt";
        System.out.println("write file. " + outputFile);

        try {
            FileWriter fileWriter = new FileWriter(outputFile, true); //Set true for append mode
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(order + " " + size + " " + algorithm + " " + totalTime);  //New line
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }


    public static int[] buildArray(String input, int size) {

        switch (input) {
            case "ascending":
                return buildAscendingArray(size);
            case "descending":
                return buildDescendingArray(size);
            case "random":
                return buildRandomArray(size);

        }
        return null;
    }

    private static int[] buildAscendingArray(int size) {
        int[] result = new int[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    private static int[] buildDescendingArray(int size) {
        int[] result = new int[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = result.length - i;
        }
        return result;
    }

    private static int[] buildRandomArray(int size) {
        Random rd = new Random();
        int[] result = new int[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = rd.nextInt();
        }
        return result;
    }

    private static long initAnalysis(int[] array, String algorithm, String outputFile) throws StackOverflowError {

        long startTime = System.nanoTime();

        switch (algorithm) {

            case ("bubble"):
                Sort.bubbleSort(array);
                break;
            case ("insertion"):
                Sort.insertionSort(array);
                break;
            case ("merge"):
                Sort.mergeSort(array);
                break;
            case ("quick"):
                Sort.quickSort(array);
                break;
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        processSorted(array, outputFile);
        return totalTime;
    }

    private static void processSorted(int[] array, String outputFile) {
        String directory = System.getProperty("user.dir") + "/../";
        outputFile = directory + outputFile;
        System.out.println("write file." + outputFile);

        try {
            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");

            for (int i = 0; i < array.length; i++) {
                writer.println(array[i]);

            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }
}

