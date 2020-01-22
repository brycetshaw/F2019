import java.util.ArrayList;


public class Tree {
    private Student root;

    public Tree() {
        root = null;
    }

    public Student getRoot() {
        return root;
    }

    public void setRoot(Student root) {
        this.root = root;
    }

    public void insert(Student student) {

        if (student == null) {
            return;
        }

        if (isEmpty()) {
            root = student;
            return;
        }

        if (isEmpty()) {
            root = student;
        } else {
            root.insert(student);
        }


    }

    public boolean isEmpty() {
        return (getRoot() == null);
    }

    public String peek() {
        return root.toString();
    }

    public void printLeft(Student cursor) {
        if (cursor != null) {
            System.out.println(cursor.toString());
            printLeft(cursor.getLeft());
        }

    }

    public void print() {

        ArrayList<String> printTree = new ArrayList<>();

        printTree = traverseAcross(printTree, root, 0);

        for (int j = 0; j < printTree.size(); j++) {
            System.out.println(printTree.get(j));
        }
    }

    private ArrayList traverseDown(ArrayList<String> printTree, Student cursor, int depth) {

        if(cursor == null) {
            for(int i = 0; i< printTree.size(); i++) {
                String filled = StringUtils.repeat("*", 10);
                String whitespace = new String()
                printTree.add(i,  printTree.get(i));

            }

            return printTree;}

        if (printTree.size() > depth) {
            printTree.add(depth, printTree.get(depth) + " " + cursor.toString());

        } else {
            printTree.add(depth, cursor.toString());
        }

        cursor = cursor.getLeft();
        depth++;
        printTree = traverseDown(printTree,cursor,depth);

        return printTree;
    }

    private ArrayList traverseAcross(ArrayList<String> printTree, Student cursor, int depth) {

        if(cursor == null) { return printTree;}

        printTree = traverseDown(printTree,cursor,depth);
        cursor = cursor.getRight();
        depth++;

        return traverseAcross(printTree,cursor,depth);
    }



}
