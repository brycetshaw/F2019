public class Word {

    private String word;
    private Word anagram;
    private char[] wordArray;

    public Word(String word) {
        this.word = word;
        wordArray = word.toCharArray();
    }

    public Word(String word, char[] wordArray) {
        this.word = word;
        this.wordArray = wordArray;

    }

    public String getWord() {
        return word;
    }


    public Word getAnagram() {
        return anagram;
    }



    public boolean checkAnagramity(String candidate) {

        if(candidate.length() != wordArray.length) {
            return false;
        }

        char[] candidateArray = candidate.toCharArray();

        int xor = 0;
        for(int i = 0; i < candidateArray.length; i++) {
            xor ^= candidateArray[i] ^ wordArray[i];
        }

        if( xor == 0){
            this.anagram  = new Word( candidate, candidateArray);
            return true;
        } else {
            return false;
        }
    }

    public boolean isLargerThan(Word comparisonWord) {
        // Function isn't able to differentiate between a and aa. This doesn't matter in this case.
        char[] comparisonArray = comparisonWord.getWordArray();

        for(int i = 0; i < wordArray.length && i < comparisonArray.length; i++) {
            if(wordArray[i] > comparisonArray[i]) {
                return true;
            } else if (wordArray[i] < comparisonArray[i]) {
                return false;
            }
        }
        return false;
    }

    public char[] getWordArray() {
        return wordArray;
    }

    public void setAnagram(Word current) {
        anagram = current;
    }
}
