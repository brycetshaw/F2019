public class Student {
    private int id;
    private String name;
    private Student next;

    public Student (String name, int id) {
        this.setId(id);
        this.setName(name);
        this.setNext(null);
    }

    public void setNext(Student o) {
        this.next = o;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student getNext() {
        return next;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", id: " + id;
    }



}
