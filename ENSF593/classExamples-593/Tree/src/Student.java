public class Student {

    private int id;
    private String name;

    private Student left;
    private Student right;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        setLeft(null);
        setRight(null);
    }

    public Student getLeft() {
        return left;
    }

    public void setLeft(Student left) {
        this.left = left;
    }

    public Student getRight() {
        return right;
    }

    public void setRight(Student right) {
        this.right = right;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void insert(Student student) {
        if (student.getId() > getId()) {
            if ((getLeft() == null)) {
                setLeft(student);
            } else {
                getLeft().insert(student);
            }
        } else {

            if(getRight() == null) {
                setRight(student);
            } else {
                getRight().insert(student);
            }
        }
    }

    @Override
    public String toString() {
        return " " + getId();
    }
}
