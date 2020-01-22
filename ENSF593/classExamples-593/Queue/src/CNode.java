public class Node {
	
	private int id;
	private Node next;
	
	public Node (int id) {
		setId(id);
		setNext(null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	public String toString () {
		return id + "";
	}

}
