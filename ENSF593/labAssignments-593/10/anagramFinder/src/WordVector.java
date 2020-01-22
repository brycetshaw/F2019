public class WordVector {

    private Word[] vector = new Word[0];
    private int cursor;

    public WordVector(int numWords) {
        vector = new Word[numWords];
        cursor = 0;
    }

    public void add(Word word) {
        if (cursor < vector.length) {
            vector[cursor++] = word;
        }
    }

    public void sort() {
        qSort(0, vector.length - 1);
    }

    private int countUnique() {
        int count = 0;
        int j = 0;
        for (int i = 1; i < vector.length; i++) {
            if (vector[i].getSorted().compareTo(vector[j].getSorted()) != 0) {
                j = i;
                count++;
            }
        }
        return count;
    }

    public void collapseVector() {
        Word[] newVector = new Word[countUnique()];
        int j = 0;
        int inserted = 0;
        boolean anagramsScrambled = false;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].checkAnagramity(vector[j])) {
                if (anagramsScrambled) {
                    vector[j].insertSort();
                    newVector[inserted++] = vector[j];
                    anagramsScrambled = false;
                }
                j = i;
            } else {
                vector[j].setAnagram(vector[i]);
                anagramsScrambled = true;
            }
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition(int low, int high) {
        String pivot = vector[high].getSorted();
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            int strTest = pivot.compareToIgnoreCase(vector[j].getSorted());

            if (strTest > 0) {
                i++;

                // swap arr[i] and arr[j]
                Word temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Word temp = vector[i + 1];
        vector[i + 1] = vector[high];
        vector[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void qSort(int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(low, high);

            // Recursively sort elements before
            // partition and after partition
            qSort(low, pi - 1);
            qSort(pi + 1, high);
        }
    }

}
