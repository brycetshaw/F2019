
public class Heap2 {
	
	int [] arr = {10, 30, -1, 5, 9, 159, 14, 4, 500, 45, -3};
	//left child: 2i + 1, where the position is < n
	//right child: 2i + 2, where position is < n
	//parent: (i - 1)/2, where 1 < i < n
	
	public void createHeap (int n) {// top-down approach to construct heap 
		
		for (int i = 0; i < n; i++) {
			int j = i;
			while ((j > 0) && (arr[(j-1)/2] < arr[j])){//checking to see if we need to replace the parent
				print();
				int temp = arr [(j-1)/2];
				arr [(j-1)/2] = arr[j];
				arr[j] = temp;
				j = (j-1)/2; // setting j to the index of the parent 
				
			}
		}
	}
	public void heapSort () {
		for (int i = arr.length - 1; i > 0; i--) {
			
			createHeap (i+1);
			
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			print();
		}
	}
	public void print () {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public void printHeap (int n) {
		
	}
	public static void main (String [] args) {
		
		Heap2 hp = new Heap2 ();
		
		hp.heapSort();
		
		hp.print();
		
	}


	public static void dropSort(int[] array)

}
