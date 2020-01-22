public class MergeSort {


    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid + 1, last);
            merge(arr, first, mid, last);

        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //1- find the sizes of the left and right subarrays which are to be merged
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        //2-
        int[] leftTemp = new int[leftSize];
        int[] rightTemp = new int[rightSize];

        //3- copy data to temp arrays
        for (int i = 0; i < leftSize; i++) {
            leftTemp[i] = arr[i + left];
        }

        //4- merge the temp array indices for the temp array.
        for (int i = 0; i < rightSize; i++) {
            rightTemp[i] = arr[mid + i + 1];
        }

        int iLeft = 0, iRight = 0;
        int j = left;
        while (iLeft < leftSize && iRight < rightSize) {

            if (leftTemp[iLeft] <= rightTemp[iRight]) {
                arr[j] = leftTemp[iLeft];
                iLeft++;
            } else {
                arr[j] = rightTemp[iRight];
                iRight++;
            }
            j++;
        }
        while (iLeft < leftSize) {
            arr[j] = leftTemp[iLeft];
            iLeft++;
            j++;
        }
        while (iRight < rightSize) {
            arr[j] = rightTemp[iRight];
            iRight++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,10,3,4,5,2};
        mergeSort(arr,0, arr.length-1);

        for ( int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
