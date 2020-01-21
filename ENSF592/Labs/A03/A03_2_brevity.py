import random
import string
import os
from scipy import stats
import numpy as np


def process_file(filename, skip_header):
    """Makes a histogram that contains the words from a file.

    filename: string
    skip_header: boolean, whether to skip the Gutenberg header

    returns: map from each word to the number of times it appears.
    """
    hist = {}

    # local = os.getcwd()
    # fp = open(local + '/' + filename, "r")
    fp = open(filename)
    # words = fin.read()

    if skip_header:
        skip_gutenberg_header(fp)

    for line in fp:
        if line.startswith('FINIS'):
            break

        process_line(line, hist)

    return hist


def skip_gutenberg_header(fp):
    """Reads from fp until it finds the line that ends the header.

    fp: open file object
    """
    for line in fp:
        if line.startswith('CHAPTER I'):
            break


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

        # update the histogram
        hist[word] = hist.get(word, 0) + 1


def most_common(hist):
    """Makes a list of word-freq pairs in descending order of frequency.

    hist: map from word to frequency

    returns: list of (frequency, word, word length) tuples
    """
    t = []
    for key, value in hist.items():
        t.append((value, len(key), key))

    t.sort()
    t.reverse()
    return t


def print_most_common(t, num):
    """Prints the most commons words in a histgram and their frequencies.

    hist: histogram (map from word to frequency)
    num: number of words to print
    """

    print('The most common words are:')
    for freq, length, word in t[:num]:
        print(word, '\t', freq)


def spearmanRank(t):
    """
    takes input in an array form, 
    where each row is ('word frequency', word, word length) 
    it then adds an index, resorts the row by word length and adds an
    index for the sorting word length wise. These two indexes are used to 
    compute the spearman number. 

    To deal with tied elements, a fractional ranking system is used, 
    without which the results are not valid, as per wikipedia 
    "Only if all n ranks are distinct integers, it can be computed using the popular formula"
    """
    x = [i[0] for i in t]
    y = [i[1] for i in t]

    x = stats.rankdata(x)
    y = stats.rankdata(y)

    sumDi2 = 0
    for i in range(len(x)):
        sumDi2 += (x[i] - y[i])**2
    n = len(x)
    spearman = 1 - (sumDi2 * 6 / (n * (n * n - 1)))
    return spearman


def main():
    hist = process_file('emma.txt', skip_header=False)
    t = most_common(hist)
    print_most_common(t, 10)

    # Commented out is some test data from wikipedia.
#    testData = [
#        (86, 0),
#        (97, 20),
#        (99, 28),
#        (100, 27),
#        (101, 50),
#        (103, 29),
#        (106, 7),
#        (110, 17),
#        (112, 6),
#        (113, 12)
#    ]
#    print("test data spearman rank:", spearmanRank(testData))
    t1 = []

    for (freq, length, word) in t:
        t1.append((freq, length))

    print('\nSpearman rank for the 100 most frequent words in Emma:')
    print("My implementation of spearman rank:", spearmanRank(t1[:100]))

    spearman_rho, p = stats.spearmanr(t1[:100])
    print('Scipy implementation of spearman rank:', spearman_rho)


if __name__ == '__main__':
    main()
