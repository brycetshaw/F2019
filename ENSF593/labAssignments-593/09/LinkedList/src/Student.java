/**
 * The type Student.
 */
//This is the "Node". i.e. class Student is used to create a
//linkedList, such that each Student object is a node in the linkedList.
public class Student {

    private int id;
    private String name;
    private Student next; //object reference that points to the next object

    /**
     * Instantiates a new Student.
     *
     * @param name the name
     * @param id   the id
     */
    public Student (String name, int id) {
        setId(id);
        setName(name);
        setNext(null);
        //Good practice to set the next pointer to null when creating
        //a new node
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets id.
     *
     * @param depth - how many nodes deep to return id from
     * @return the id
     * @throws LinkedListException the linked list exception
     */
    public int getId(int depth) throws LinkedListException {
        Student target = this;

        for(int i = 0; i < depth; i++) {
            target = target.getNext();
        }
        if (target == null) throw new LinkedListException("Id search depth exceeds linked list depth.");
        return target.getId();
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Student getNext() {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(Student next) {
        this.next = next;
    }
    @Override
    public String toString () {
        return "Name: " + getName() + " ID Number: " + getId();
    }
}