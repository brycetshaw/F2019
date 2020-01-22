public class TreeApp {
    public static void main(String[] args) {
        Tree myTree = new Tree();
        myTree.insert(new Student(10, "ten" ));
        myTree.insert(new Student(12, "twelve" ));
        myTree.insert(new Student(9, "nine" ));
        myTree.insert(new Student(11, "eleven" ));


        myTree.print();

        //                10
        //           12         9
        //              11


    }
}
