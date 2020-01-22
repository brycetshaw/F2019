
public class StudentLinkedList {
	
	private Student head;
	
	public StudentLinkedList () {
		head = null;
	}
	public void insertToEndOfList(Student s) {
		
		if (head == null) {
			head = s;
		}
		else {	
			getLastNode().setNext(s);
		}
		
	}
	public void insertToFrontOfList (Student s) {
		if (head == null) {
			head = s;
		}
		else {
			s.setNext(head);
			head = s;
		}
	}
	//we create a wrapper method so that we don't have to pass the head from main. The actual 
	//recursive implementation is done in the overloaded recursivePrintList which takes a Student
	//object as an argument. 
	public void recursivePrintList () {
		recursivePrintList (head);
	}
	private void recursivePrintList (Student cursor) {
		
		if (cursor != null) {
			
			recursivePrintList (cursor.getNext());
			System.out.println(cursor);
		}
	}
	public void printList () {
		Student cursor = head;
		while (cursor != null) {
			System.out.println(cursor);
			cursor = cursor.getNext();
		}
		
	}
	private Student getLastNode() {
		Student cursor = head;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		return cursor;
	}
	public Student getHead() {
		return head;
	}

}






