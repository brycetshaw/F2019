
public class CircularQueue {
	
	private Node tail;
	//in a circular queue, the pointer of the node that tail is pointing at is
	//head
	//so, tail.next is infact head!
	
	public CircularQueue () {
		tail = null;
	}
	public void enqueue(Node node) {
		if (tail == null) {
			tail = node;
			tail.setNext(tail);
		}
		else {
			node.setNext(tail.getNext());
			tail.setNext(node);
			tail = node;
		}
	}
	public Node dequeue () {
		if (tail == null)//if no elements in the queue
			return null;
		
		Node temp = tail.getNext();
		if (tail.getNext() == tail) {//if there is only one element in the queue
			tail = null;
		}
		else {
			tail.setNext(temp.getNext());
		}
		return temp;
	}
	public void print() {
		if (tail == null) {
			System.out.println("The Queue is empty!");
			return;
		}
		Node head = tail;
		do {
			head = head.getNext();
			System.out.println(head);
		}while (head != tail);
		
		
	}

}
