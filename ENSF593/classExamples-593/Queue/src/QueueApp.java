public class QueueApp {
    public static void main(String[] args) {
        Queue myQ = new Queue();

        myQ.enqueue(new Node(5));
        myQ.enqueue(new Node(10));

        myQ.print();
    }




}
