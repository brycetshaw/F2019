import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Random rd = new Random();
        System.out.println("10^x -> n > operations");
        generateTimes(9, rd);



        System.out.println("\tPlotting these results, this is a linear relation. Because the size of input n is \n" +
                "\tincreasing by exponentially with each step, this means that the complexity of the binary search is \n" +
                "\tO(log(n)).... log ( 10 ^ x ) = x . \n" +
                "\t(Exponentially increasing input size is mapped to linearly increasing search operations.)");


    }

    public static int binarySearch(int[] arr, int key) {
        int lo = 0, mid, hi = arr.length - 1, count = 4;
        while (lo <= hi) {
            count = count + 7;
            mid = (lo + hi) / 2;
            if (key < arr[mid])
                hi = mid - 1;
            else if (arr[mid] < key)
                lo = mid + 1;
            else return count;
        }
        return count;
// success: return the index of
// the cell occupied by key;
// failure: key is not in the array;
    }

    public static int[] generateArray(int power, Random rd) {

        int[] array = new int[(int) Math.pow(10, (double) power)];
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt();
        }
        return array;
    }

    public static void generateTimes(int sample, Random rd) {
        Long[] response = new Long[sample];

        String st = "";

            for (int i = 0; i < response.length; i++) {
                int[] testArray = generateArray(i, rd);

                System.out.println(i + "         |  " + binarySearch(testArray, 100));
            }



    }
}
