import java.util.Scanner;

public class Record {

    private String studentNumber;
    private String lastName;
    private String department;
    private String program;
    private String year;
    private Record left;
    private Record right;



    public String getLastName() {
        return lastName;
    }

    public Record getLeft() {
        return left;
    }

    public void setLeft(Record left) {

        this.left = left;
    }

    public Record getRight() {
        return right;
    }

    public void setRight(Record right) {

        this.right = right;
    }



    public Record(String fileLine) {

        this.studentNumber = fileLine.substring(1, 8);
        this.lastName = fileLine.substring(8, 33).strip();
        this.department = fileLine.substring(33, 37);
        this.program = fileLine.substring(37, 41).strip();
        this.year = fileLine.substring(fileLine.length() - 1);
        left = right = null;
    }

    public Record(String studentNumber, String lastName, String department, String program, String year) {

        this.studentNumber = studentNumber;
        this.lastName = lastName;
        this.department = department;
        this.program = program;
        this.year = year;
        left = right = null;
    }

    public void add(Record record) {

        if (record.isGreaterThan(this.lastName)) {
            if (getRight() != null) {
                getRight().add(record);
            } else {
                setRight(record);
            }
        } else {
            if (getLeft() != null) {
                getLeft().add(record);
            } else {
                setLeft(record);
            }
        }
    }

    public boolean isGreaterThan(String lastName) {

        if (this.lastName.compareToIgnoreCase(lastName) > 0) {
            return true;
        }
        return false;
    }



    public Record getMostRight() {
        if (getRight() != null) {
            return getRight().getMostRight();
        }
        return this;
    }

    @Override
    public String toString() {
        return lastName + " " + studentNumber;
    }

    public void copyAcross(Record mostRight) {
        this.lastName = mostRight.lastName;
        this.studentNumber = mostRight.studentNumber;
        this.year = mostRight.year;
        this.program = mostRight.program;
        this.department = mostRight.department;

    }
}