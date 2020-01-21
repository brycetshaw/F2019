# Section 1.1
# Had I read the text book section chapter 13,
# I would have stuctured my code to read the contents in line by line,
# instead of inputting it in one bit list of strings. It was very challenging
# to figure out how to access the innet contents of the list of strings, especially
# as split methods created lists of lists. As well, having to create for loops was a
# big pain, whereas line by line the problem is easier to keep track of. I would also
# have made use of the string.punctuation and string.whitespace features of the string class
# instead of using regular expressions.

# Section 1.2
# To make the analyze book script work I has to set the "skip_header flag" to False.
# Otherwise it would go through the entire text file looking for the header and get to
# the end without finding it.
#
# A similar change had to be made in the markov.py script, after removing the gutenberg
# header skip, the output of the script was :

#   # generalizations—to guess at the wonderful, simple, but very strange patterns beneath them all,
#   # and then there are theoretical physicists who imagine, deduce, and guess at the wonderful, simple,
#   #  but very strange patterns beneath them all, and then there are theoretical physicists who
#   #   experiment, imagine, deduce, and guess. We said that the new law makes no significant difference.
#   #    Well, yes and no. For ordinary speeds we are completely wrong with the approximate law.
#   #     Our entire picture of the first idea. This point arises again and again in teaching physics.
#   #      At different times we shall have to go to graduate school too!

import random
import string
import os


def process_file(filename, skip_header):
    """Makes a histogram that contains the words from a file.

    filename: string
    skip_header: boolean, whether to skip the Gutenberg header

    returns: map from each word to the number of times it appears.
    """
    hist = {}

    #local = os.getcwd()
    #fp = open(local + '/' + filename, "r")
    fp = open(filename)
    #words = fin.read()

    if skip_header:
        skip_gutenberg_header(fp)

    for line in fp:
        if line.startswith('*** END OF THIS'):
            break

        process_line(line, hist)

    return hist


def process_line(line, hist):
    """Adds the words in the line to the histogram.

    Modifies hist.

    line: string
    hist: histogram (map from word to frequency)
    """
    # TODO: rewrite using Counter

    # replace hyphens with spaces before splitting generalizations—to extent—that
    line = line.replace('-', ' ')
    line = line.replace('—', ' ')
    strippables = string.punctuation + string.whitespace + '”' + '“' + '—' + '.'

    for word in line.split():
        # remove punctuation and convert to lowercase
        word = word.strip(strippables)
        word = word.lower()

        for letter in word:
            hist[letter] = hist.get(letter, 0) + 1

        # update the histogram
        #hist[word] = hist.get(word, 0) + 1


def most_common(hist):
    """Makes a list of word-freq pairs in descending order of frequency.

    hist: map from word to frequency

    returns: list of (frequency, word) pairs
    """
    t = []
    for key, value in hist.items():
        t.append((value, key))

    t.sort()
    t.reverse()
    return t


def print_most_common(hist, num=10):
    """Prints the most commons words in a histgram and their frequencies.

    hist: histogram (map from word to frequency)
    num: number of words to print
    """
    t = most_common(hist)
    print('The most common words are:')
    for freq, word in t[:num]:
        print(word, '\t', freq)


def main():
    hist = process_file('feynman.txt', skip_header=False)

    t = most_common(hist)
    print('The most common letters are:')

    for freq, word in t[0:10]:
        print(word, '\t', freq)

    print('The least common letters are:')

    for freq, word in t[16:26]:
        print(word, '\t', freq)

    words = process_file('feynman.txt', skip_header=False)


if __name__ == '__main__':
    main()
