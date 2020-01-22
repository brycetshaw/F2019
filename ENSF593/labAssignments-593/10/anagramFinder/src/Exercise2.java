

public class Exercise2 {


    //I was not able to finish this assignment. I got halfway through implementing this with the outer word list being
    // an array but I was having trouble figuring out how to account for the decreasing size (from merging anagrams)
    // of the array with the requirement that we not use an array list. Then I tried making a linked list, then I ran
    // out of time.

    // this is where I got to. Cheers!


    public static void main(String[] args) {
        String inputFile = args[0];

        String outputFile = args[1];

        //1. import strings from input
        //2. split strings into String[]
        //3. for loop to create word objects and add to WordVector
        String imported = "";
        String[] split = imported.split("\n");



        WordVector words = new WordVector(split.length);

        for (String s: split) {
            words.add(new Word(s));
        }
        //4. collapse word vector
        //5. sort the word vector
        //6. print to output file.



    }

}


