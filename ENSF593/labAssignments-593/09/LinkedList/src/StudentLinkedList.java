/**
 * The type Student linked list.
 */
public class StudentLinkedList {

    private Student head;
    private boolean sorted;

    /**
     * Instantiates a new Student linked list.
     */
    public StudentLinkedList() {
        head = null;
        sorted = true;
    }

    /**
     * Insert to end of list.
     *
     * @param s the s
     */
    public void insertToEndOfList(Student s) {
        try {
            checkUniqueId(s);
            if (setEmptyHead(s)) {
                getLastNode().setNext(s);
                sorted = false;
            }
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert to front of list.
     *
     * @param s the s
     */
    public void insertToFrontOfList(Student s) {
        try {
            checkUniqueId(s);
            if (setEmptyHead(s)) {
                s.setNext(head);
                head = s;
                sorted = false;
            }
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean setEmptyHead(Student s) {
        if (head == null) {
            head = s;
            return false;
        }
        return true;
    }


    /**
     * Gets last node.
     *
     * @return the last node
     */
    public Student getLastNode() {
        Student cursor = head;
        while (cursor.getNext() != null) {
            cursor = cursor.getNext();
        }
        return cursor;
    }


    /**
     * Recursive print list.
     */
    public void recursivePrintList() {
        System.out.println("---");
        recursivePrintList(head);
        System.out.println("---");
    }

    private void recursivePrintList(Student cursor) {

        if (cursor != null) {
            recursivePrintList(cursor.getNext());
            System.out.println(cursor);
        }
    }

    /**
     * Print list.
     */
    public void printList() {
        System.out.println("---");
        Student cursor = head;
        while (cursor != null) {
            System.out.println(cursor);
            cursor = cursor.getNext();
        }
        System.out.println("---");
    }

    private Student getHead() {
        return head;
    }

    /**
     * Insert ordered.
     *
     * @param insert the insert
     */
    public void insertOrdered(Student insert) {
        try {

            if (sorted = false) {
                this.sort();
            }
            checkUniqueId(insert);

            if (setEmptyHead(insert)) {
                if (this.head.getId() > insert.getId()) {
                    this.insertToFrontOfList(insert);
                    return;
                }
                insertOrdered(insert, this.head);
            }

        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }
    }

    private Student insertOrdered(Student insert, Student node) throws LinkedListException {

        if (node == null) { // this is when head == null...
            this.head = insert;
            return null;

        } else if (node.getNext() == null) { //this is the end of the list...
            node.setNext(insert);
            return insert;

        } else if (node.getId(1) > insert.getId()) {
            insert.setNext(node.getNext());
            node.setNext(insert);
            return insert;

        } else {
            return insertOrdered(insert, node.getNext());
        }
    }

    private void checkUniqueId(Student insert) throws LinkedListException {
        if (search(insert.getId()) != null) {
            throw new LinkedListException("Student ID numbers must be unique.");
        }
    }


    /**
     * Search student.
     *
     * @param id the id
     * @return the student
     */
    public Student search(int id) {
        try {
            return sorted ? BinarySearch.binarySearch(head, id, 0) : unsortedSearch(id, head);
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    private Student unsortedSearch(int id, Student node) {
        if (node == null) {
            return null;
        } else if (node.getId() == id) {
            return node;
        } else {
            return unsortedSearch(id, node.getNext());
        }
    }


    /**
     * Remove element student.
     *
     * @param id the id
     * @return the student
     */
    public Student removeElement(int id) {

        if (head.getId() == id) {
            Student deleted = head;
            this.head = head.getNext();
            deleted.setNext(null);
            return deleted;
        }

        try {
            return sorted ? sortedRemoveElement(id) : unSortedRemoveElement(id, this.head);
        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    private Student sortedRemoveElement(int id) throws LinkedListException {
        Student deleteRef = BinarySearch.binarySearch(head, id, 1);
        if (deleteRef != null) {
            return popNext(deleteRef);
        }
        return null;
    }

    private Student popNext(Student deleteRef) {
        Student deleted = deleteRef.getNext();
        deleteRef.setNext(deleteRef.getNext().getNext());
        deleted.setNext(null);
        return deleted;
    }

    private Student unSortedRemoveElement(int id, Student node) {
        if (node == null) {
            return null;
        } else if (node.getNext().getId() == id) {
            return popNext(node);
        } else {
            return unSortedRemoveElement(id, node.getNext());
        }
    }


    /**
     * Sort.
     */
    public void sort() {
        boolean changeHappened = false;
        do {

            Student current = head;
            Student next = head.getNext();
            Student previous = null;
            changeHappened = false;

            while (current.getNext() != null) {
                if (current.getId() > next.getId()) {
                    //we have to swap
                    changeHappened = true;
                    current.setNext(next.getNext());
                    next.setNext(current);
                    if (previous == null) {
                        //first iteration
                        head = next;
                    } else {
                        //we are in the middle
                        previous.setNext(next);
                    }
                    previous = next;
                    next = current.getNext();
                } else {
                    previous = current;
                    current = current.getNext();
                    next = next.getNext();
                }
            }
        } while (changeHappened);
        sorted = true;
    }


}





