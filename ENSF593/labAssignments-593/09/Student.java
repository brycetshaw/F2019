//This is the "Node". i.e. class Student is used to create a
//linkedList, such that each Student object is a node in the linkedList.
public class Student {

	private int id;
	private String name;
	private Student next; //object reference that points to the next object
	
	public Student (String name, int id) {
		setId(id);
		setName(name);
		setNext(null);
		//Good practice to set the next pointer to null when creating
		//a new node
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getNext() {
		return next;
	}

	public void setNext(Student next) {
		this.next = next;
	}
	@Override
	public String toString () {
		return "Name: " + getName() + " ID Number: " + getId();
	}
}
