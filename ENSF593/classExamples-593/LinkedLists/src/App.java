public class App {

    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        theList.insertOrdered(new Student("Joe", 5));
        theList.insertOrdered(new Student("Jim", 17));
        theList.insertOrdered(new Student("Jim", 11));
        theList.insertOrdered(new Student("Jim", 1));
        System.out.println(theList);

    }
}
