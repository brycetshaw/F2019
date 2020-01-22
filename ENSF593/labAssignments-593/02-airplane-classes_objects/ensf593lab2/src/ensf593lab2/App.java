package ensf593lab2;

public class App {
	
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
