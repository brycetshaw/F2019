public class Queue {

    private Node head;
    private Node tail;

    public Queue() {
        setHead(null);
        setTail(null);
    }


    public void setHead(Node head) {
        if (isEmpty()) {
            this.head = head;
            this.tail = head;
        } else if () {
            head.setNext(this.head);
            this.head = head;
        }
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        if ((isEmpty())) {
            this.head = tail;
            this.tail = tail;
        } else {
            this.getTail().setNext(tail);
            this.tail = tail;
        }
    }

    public boolean isEmpty() {
        if ((head == null) || (getTail() == null)) {
            return true;
        }
        return false;
    }

    public void enqueue(Node node) {
        setTail(node);
    }

    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node temp = head;
        if (getTail() == head) {
            setHead(null);
            setTail(null);
        } else {
            head = head.getNext();
        }
        return returnNode(temp);
    }

    private Node returnNode(Node temp) {
        temp.setNext(null);
        return temp;
    }

    @Override
    public String toString() {
        return head.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }
}
