
public class StudentLinkedListApp {

    public static void main (String [] args) {

        StudentLinkedList theList = new StudentLinkedList();
        theList.insertToEndOfList(new Student ("Joe", 5));
        theList.insertToEndOfList(new Student ("Sarah", 40));
        theList.insertToEndOfList(new Student ("Sam", 22));
        theList.insertToEndOfList(new Student("Jose", 10));
        theList.insertToEndOfList(new Student("Franz", 150));


        theList.sort();
        theList.printList();


        System.out.println(theList.removeElement(5));

        theList.printList();

        System.out.println(theList.removeElement(40));

        theList.printList();
        theList.insertOrdered(new Student("hippy",1));
        theList.insertToEndOfList(new Student("dippy", 4));
        theList.insertToEndOfList(new Student("doppy", 4));
        theList.printList();
        theList.sort();
        theList.printList();



//        theList.recursivePrintList ();


    }

}