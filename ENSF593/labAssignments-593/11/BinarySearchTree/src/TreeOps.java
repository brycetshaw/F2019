import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class TreeOps {

    public static Record add(Record root, Record record) {
        if (root == null) {
            root = record;
        } else {
            add(root, record);
        }
        return root;
    }


    public static Record delete(Record root, String data) {


        if (root == null) {
            return null;
        }
        int compareTest = root.getLastName().compareToIgnoreCase(data);

        if (compareTest > 0) {
            root.setLeft(delete(root.getLeft(), data));

        } else if (compareTest < 0) {
            root.setRight(delete(root.getRight(), data));
        } else {

            // no child case
            if (root.getLeft() == null && root.getRight() == null) {
                return null;

                // 1 child case
            } else if (root.getRight() == null) {

                return root.getLeft();

            } else if (root.getLeft() == null) {
                return root.getRight();

                // 2 child case
            } else {
                root.copyAcross(root.getLeft().getMostRight());

                // wow. this was a big lesson in the horrible consequences of shallow copying.
//                root = root.getLeft().getMostRight();
                root.setLeft(delete(root.getLeft(), root.getLastName()));

            }
        }


        return root;

    }

    public static Record binarySearch(Record root, String searchLastName) {
        int test = root.getLastName().compareToIgnoreCase(searchLastName);
        if (test == 0) {
            return root;
        }

        if (test > 0) {
            return (root.getLeft() != null) ? binarySearch(root.getLeft(), searchLastName) : null;
        } else {
            return (root.getRight() != null) ? binarySearch(root.getRight(), searchLastName) : null;
        }
    }


    public static String TreeString(Record root) {

        class Node {
            private Node next;
            private Record record;
            private boolean isEndOfLine;

            public Node(Record record) {
                this.record = record;
                this.next = null;
                this.isEndOfLine = false;
            }

            public Node() {
                this.record = null;
                this.next = null;
                this.isEndOfLine = true;
            }


            public void enqueue(Record record) {
                if (next != null) {
                    next.enqueue(record);
                } else {
                    next = new Node(record);
                }
            }

            public void enqueueEOL() {
                if (next != null) {
                    next.enqueueEOL();
                } else {
                    next = new Node();
                }
            }

            public Record getRecord() {
                return record;
            }
        }

        class Queue {
            private Node root;

            public Queue(Record rootRecord) {
                this.root = new Node(rootRecord);
            }

            public Record dequeue() {
                Record upNext = root.getRecord();
                this.root = root.next;
                return upNext;
            }

            public void enqueue(Record record) {

                if (root != null) {
                    root.enqueue(record);
                } else {
                    root = new Node(record);
                }
            }

            public void enqueueEOL() {

                if (root != null) {
                    root.enqueueEOL();
                } else {
                    root = new Node();
                }
            }

            public boolean isEmpty() {
                return (this.root == null);
            }


            public boolean isNewLine() {
                if (root.isEndOfLine) {
                    this.root = root.next;
                    return true;
                }
                return false;
            }
        }

        Queue queue = new Queue(root);
        String st = "";
        queue.enqueueEOL();


        while (!queue.isEmpty()) {


            if (queue.isNewLine()) {
                System.out.println(st);
                st = "";
                if (!queue.isEmpty()) {
                    queue.enqueueEOL();
                }

            } else {
                Record activeNode = queue.dequeue();


                if (activeNode != null) {
                    st += activeNode.toString() + " ";
                    queue.enqueue(activeNode.getLeft());
                    queue.enqueue(activeNode.getRight());
                }

            }
        }
        return st;
    }


    public static void printDepth(PrintWriter writer,  Record root) {
        String st = "";

        if (root == null) {
            return ;
        }

        if (root.getLeft() != null) {
            printDepth(writer, root.getLeft());
        }

        writer.println(root.toString());

        if (root.getRight() != null) {
            printDepth(writer, root.getRight());
        }
    }

    public static Tree buildTree(String inputFile) throws FileNotFoundException {
        Tree tree = new Tree();
        File file = new File(inputFile);
        FileReader reader = new FileReader(file);
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNext()) {
            String lineText = sc.nextLine();

            System.out.println(lineText.substring(0, 1));
            if (lineText.substring(0, 1).compareToIgnoreCase("I") == 0) {
                tree.add(new Record(lineText));
                count++;
            } else if (lineText.substring(0, 1).compareToIgnoreCase("D") == 0) {
                tree.delete(lineText.substring(8, 33).strip());
                count--;
            }
        }
        System.out.println("imported " + count + "\n");
        return tree;
    }


}
