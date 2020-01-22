public class Node {
    private int data;
    private Node right;
    private Node left;
    private int balance;

    public void setBranch(Node node, Node branch) {

        if (branch == null) {
            branch = node;
        } else {
            branch.add(node);
        }
    }

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
        this.balance = 0;
    }

    public void add(Node node) {
        if (node.getData() > this.getData()) {
            this.balance += 1;
            setBranch(node, this.left);
        } else {
            this.balance -= 1;
            setBranch(node, this.right);
        }
    }

    public int getData() {
        return data;
    }
}


                       10
                      5   20
                    3  6
                        7