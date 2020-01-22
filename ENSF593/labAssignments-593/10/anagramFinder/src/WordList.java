public class WordList {
    private Word head;
    private WordList below;

    public WordList() {
        head = null;
        below = null;
    }

    public WordList(String word) {
        head = new Word(word);
        below = null;
    }

    public void add(String word) {

        if (head == null) {
            head = new Word(word);
        } else if (!head.checkAnagramity(word)) {
            if( below == null) {
                below = new WordList(word);
            } else {
                below.add(word);
            }
        }
    }

    public void orderAnagrams() {

        Word current = head.getAnagram();
        Word next = current;
        Word tail = null;

        while (current != null) {

            if(head.isLargerThan(current)) {
                head.setAnagram(current.getAnagram());
                current.setAnagram(head);
                head = current;
            } else {
                while (next != current) {

                }
            }
            current = current.getAnagram();

        }
    }
}
