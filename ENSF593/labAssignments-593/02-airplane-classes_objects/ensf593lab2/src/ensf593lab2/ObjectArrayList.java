package ensf593lab2;

import java.util.Scanner;




public class ObjectArrayList {
	
	private Point[] ptSet;
	
	/**
	 * Default constructor
	 */
	public ObjectArrayList () {ptSet = new Point[0];}
	
	/**
	 * returns contents of object
	 * @return object contents Point[]
	 */
	public Point[] getPoints() {
		return ptSet;
	}
	
	/**
	 * Sets contents of object
	 * @param ptSet new object content Point[]
	 */
	public void setPoints(Point[] ptSet) {
		this.ptSet = ptSet;
	}
	
	/**
	 * adds element to end of array
	 * @param x new element
	 */
	public void addElement (Point x) {
		Point[] newPtSet = new Point[this.ptSet.length + 1];
		for(int i = 0; i< this.ptSet.length; i++) {
			newPtSet[i]=this.ptSet[i];
		}
		newPtSet[newPtSet.length-1] = x;
		this.ptSet = newPtSet;
	}
	
	/**
	 * inserts element at specified index
	 * @param i index
	 * @param j new point
	 */
	public void insertAt(int i, Point j) {
		
		if(i > this.ptSet.length) 
		{
			i = this.ptSet.length;	
		}
		
		resize(this.ptSet.length + 1);
			
		for(int index = ptSet.length-1; index >= i; index--) {
			if(index == i) {
				this.ptSet[index] = j;				
			} else {
				this.ptSet[index]= this.ptSet[index-1];
			}	
		}
	}	
	
	/**
	 * Removes point at specified index
	 * @param i index for removal
	 */
	public void removeAt(int i) {
		
		
		if(i < this.ptSet.length) {
			Point [] ogptSet = this.ptSet;
			resize(this.ptSet.length - 1);
			
			for(int j = i; j < this.ptSet.length; j++) {
				this.ptSet[j] = ogptSet[j+1];
			}
		}	
	}
	
	
	private void resize(int i) {
		
		Point [] newPtSet = new Point [i];
		
		for(int j = 0; j < i && j < this.ptSet.length; j++) {
			newPtSet[j] = this.ptSet[j];
		}
		this.ptSet = newPtSet;
	}
	/** 
	 * Prints contents of object to console
	 */
	public void printElements() {
		for(int i = 0; i < this.ptSet.length; i++) {
			System.out.println(ptSet[i]);
		}		
	}
	
	 private boolean isDouble(String str)
	 {
	     try
	     {
	         Double.parseDouble(str);
	         return true;
	     }
	     catch(NumberFormatException nfe)
	     {
	         return false;
	     }
	 }
	
	 /**
	  * Allows user to populate object
	  */
	public void GeneratePoints() {
		String answer;
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Enter your inputs in the form: name xpoint ypoint \n Type quit when done.");
		while (true) {
			
			answer = scan.nextLine();
			if (answer.toUpperCase().equals("QUIT"))
				break;
			String[] splitAnswer = answer.split("\\s+");	
			if(splitAnswer.length == 3 && isDouble(splitAnswer[1]) && isDouble(splitAnswer[2])) {
				Point newPoint = new Point( Double.parseDouble(splitAnswer[1]),  Double.parseDouble(splitAnswer[2]), splitAnswer[0] );
				addElement(newPoint);
				System.out.println("good input. thanks!");
			} else {
				System.out.println("point format error (Remember..labels can only be one word) thanks. \n");
			}
		}
		scan.close();
	}
	
	public static void main (String[] args) {
		ObjectArrayList pointSet = new ObjectArrayList();
		pointSet.GeneratePoints();
		System.out.print("\n");
		pointSet.addElement(new Point ( 45, 52, "get Schwifty"));
		pointSet.insertAt(0, new Point( 23, -12, "Mr. Bulldocks"));
		pointSet.printElements();
		System.out.print("\n");
		pointSet.removeAt(1);
		pointSet.printElements();
		
	}
	
}
