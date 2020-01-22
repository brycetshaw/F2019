public class Node {

    private int id;
    private Node next;

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

    public Node (int id) {
        this.id = id;
        next=null;
    }

    @Override
    public String toString() {
        return id + " " + ((this.getNext() != null) ? next.toString() :"");
    }
}
