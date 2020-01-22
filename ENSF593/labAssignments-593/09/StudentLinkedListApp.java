
public class StudentLinkedListApp {
	
	public static void main (String [] args) {
		
		StudentLinkedList theList = new StudentLinkedList();
		theList.insertToEndOfList(new Student ("Joe", 5));
		theList.insertToEndOfList(new Student ("Sarah", 4));
		theList.insertToEndOfList(new Student ("Sam", 2));
		theList.insertToFrontOfList(new Student ("Mo", 14));
		//theList.printList();
		theList.recursivePrintList ();


	}

}
