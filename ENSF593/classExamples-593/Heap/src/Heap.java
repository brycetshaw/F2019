public class Heap {

    int[] arr = {10, 30, -1, 5, 9, 59, 14, 4, 500};

    //left child : 2i + 1 where position is < n
    // right child 2i + 2 where position is < n
    //parent : (i-1)/2, where 1 < i < n

    public void createHeap(int n) {

        for (int i = 0; i < n ; i++) {
            int j = i;

            while ((j > 0) && (arr[(j-1)/2] < arr[j])) { // checking to see if we need to replace the parent.
                int temp = arr[(j-1)/2];
                arr[(j-1)/2] = arr[j];
                arr[j] = temp;
                j = (j-1) / 2; // setting j to the index of the parent..

            }
        }
    }

    public void heapSort() {
        for(int i = arr.length -1 ; i > 0 ; i--) {

            createHeap(i+1);

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            print(i);
        }
    }

    public static void main(String[] args) {

        Heap hp = new Heap();
        hp.createHeap(9);
        hp.heapSort();
        hp.print(9);
    }

    public void print(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}

