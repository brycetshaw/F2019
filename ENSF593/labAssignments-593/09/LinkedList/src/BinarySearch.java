/**
 * The type Binary search.
 */
public class BinarySearch {

    /**
     * Binary search student.
     *
     * @param head  the head
     * @param id    the id
     * @param depth the depth
     * @return the student
     * @throws LinkedListException the linked list exception
     */
    public static Student binarySearch(Student head, int id, int depth) throws LinkedListException {
        Student start = head;
        Student last = null;
        Student mid = middleNode(start, last);

        do {
            mid = middleNode(start, last);

            // If middle is empty
            if (mid == null)
                return null;

            // If value is present at middle
            if (mid.getId(depth) == id) {

                return mid;

            } else if (mid.getId(depth) < id)
            {

                start = mid.getNext();
            }

            // If the value is more than mid.
            else
                last = mid;
        } while (last == null || last != start );

        // value not present
        return null;
    }

    private static Student middleNode(Student start, Student last) {
        if (start == null) {
            return null;
        }

        Student slow = start;
        Student fast = slow.getNext();

        while (fast != last) {
            fast = fast.getNext();
            if (fast != last) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        return slow;
    }

}
