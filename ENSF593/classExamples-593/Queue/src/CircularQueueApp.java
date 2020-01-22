
public class CircularQueueApp {
	
	public static void main (String [] args) {
		
		CircularQueue myQ = new CircularQueue ();
		
		myQ.enqueue(new Node(10));
		myQ.enqueue(new Node(8));
		myQ.enqueue(new Node(5));
		myQ.enqueue(new Node(4));
		
		System.out.println("After all the enqueue calls:");
		myQ.print();
		
		myQ.dequeue();
		
		System.out.println("After the dequeue call:");
		myQ.print();
		
	}

}
