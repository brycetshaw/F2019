package ensf593lab2;

public class IntArrayList {
	
	private int[] array;
	
	
	/**
	 * Constructor, initializes array with a size requested. Initialized elements are all zero.
	 * @param size number of elements to initialize array with
	 */
	public IntArrayList(int size) {
		if (size > 0)
			setArray(new int [size]);
		}
	
	/**
	 * Default constructor, produces array of length 0.
	 */
	public IntArrayList () {array = new int[0];}
	
	
	/**
	 * Add element to the end of the array
	 * @param x element to be added.
	 */
	public void addElement (int x) {
		int[] newArray = new int[this.array.length + 1];
		for(int i = 0; i< this.array.length; i++) {
			newArray[i]=this.array[i];
		}
		newArray[newArray.length-1] = x;
		this.array = newArray;
	}
	/**
	 * returns contents of object
	 * @return contents of array (int[])
	 */
	public int [] getArray() {
		return array;
	}
	/**
	 * sets contents of object
	 * @param array object contents int[]
	 */
	public void setArray(int [] array) {
		this.array = array;
	}
	

	/**
	 * Print all elements in the array to console.
	 */
	public void printElements() {
		System.out.print("[ ");
		for(int i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i]);
			if(i+1 < this.array.length) {
				System.out.print(", ");
			}
		}
		System.out.print("] \n");
		
	}

	private void resize(int i) {
		
		int [] newArray = new int [i];
		
		for(int j = 0; j < i && j < this.array.length; j++) {
			newArray[j] = this.array[j];
		}
		this.array = newArray;
	}
	/**
	 * Removes element at index specified
	 * @param i
	 */
	public void removeAt(int i) {
		
		
		if(i < this.array.length) {
			int [] ogArray = this.array;
			resize(this.array.length - 1);
			
			for(int j = i; j < this.array.length; j++) {
				this.array[j] = ogArray[j+1];
			}
		}	
	}
	/**
	 * Inserts element at requested index
	 * @param i index for insertion
	 * @param j element to be added
	 */
	public void insertAt(int i, int j) {
		
		if(i > this.array.length) 
		{
			i = this.array.length;	
		}
		
		resize(this.array.length + 1);
			
		for(int index = array.length-1; index >= i; index--) {
			if(index == i) {
				this.array[index] = j;				
			} else {
				this.array[index]= this.array[index-1];
			}	
		}
	}	

		
	
	
	public static void main (String [] args) {
		IntArrayList ar = new IntArrayList ();
		
		ar.addElement(2);
	
		ar.addElement(4);
		ar.addElement(6);
		ar.addElement(8);
		
		ar.insertAt(2, 5); //inserting number 5 at index 2
		ar.removeAt(1);
		ar.printElements();
		//remove the element at index 1
		ar.resize(2);
		//the new size of the array will be 2 elements
		ar.printElements();
		//This should print all elements in the array
		}
	
}
