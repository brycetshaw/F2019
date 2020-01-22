public class LinkedList {

    public Student head;

    public LinkedList() {
        head = null;
    }

    public void insertToEndOfList(Student student) {
        if (head == null) {
            head = student;
        } else {
            tail(head).setNext(student);
        }
    }

    public void insertToFrontOfList(Student student) {
        if (head == null) {
            head = student;
        } else {
            student.setNext(head);
            head = student;
        }
    }

    public void insertOrdered(Student insert) {
        insertOrdered(insert, this.head);
    }

    private Student insertOrdered(Student insert, Student node) {
        if(node == null) { // this is when head == null...
            node = insert;
            return null;
        }

        if(node.getNext() == null) { //this is the end of the list...
            node.setNext(insert);
            return null;
        }

        if (node.getNext().getId() > insert.getId()){
            insert.setNext(node.getNext());
            node.setNext(insert);
            return null;
        }

        if (insertOrdered(insert, node.getNext()) == null) {
            return null;
        }
        return null;

    }

    private Student tail(Student node) {
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    public String toString() {
        String st = "";
        Student node = head;
        while (node != null) {
            st += node.toString() + "\n";
            node = node.getNext();
        }
        return st;
    }
}
