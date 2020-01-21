import random
import operator


class Histogram(dict):
    """A histogram to count frequencies of elements.

    Inherits dict which will hold element-frequency pairs
    Elements are provided by Lists (iterables)
    """

    def __init__(self, l=None):
        """Constructor: provide elements in a list or iterable"""

        if l != None:
            self.count(l)

    def __str__(self):
        """ returns a string representation of each element-frequency pair"""
        # TODO: Add your code
        # For each entry in histogram, this should append to return string:
        # {value} count of {element}\n
        # the last pair should not have the trailing ‘\n’
        st = ""
        for (key, value) in self.most_common():
            st += f"({value} count of {key})\n"
        return st[:-1]

    def __sub__(self, other):
        """Subtraction: Returns a dictionary with all keys that appear in self but not other.

        other: Histogram() object
        """
        # TODO: Add your code
        unique_dict = {}
        for (key, value) in self.items():
            if key not in other:
                unique_dict[key] = value
        pass
        return unique_dict

    def most_common(self, n=None):
        """Returns n most common (most frequent) elements in histogram

        if n=None, all are returned

        returns: List of Tuples, each Tuple is a element-frequancy pair
        """
        # TODO: Add your code
        # Follow analyze_book1 but make sure you add (element, frequency)
        sortList = sorted(self.items(), key=operator.itemgetter(1))
        sortList.reverse()
        return sortList[:n]

    def count(self, l):
        """Adds items in list l to the histogram"""
        # TODO: Add your code

        for element in l:
            if element not in self:
                self[element] = 1
            else:
                self[element] += 1

    def total_elements(self):
        """Returns the total of the frequencies in a histogram."""
        # TODO: Add your code
        countSum = 0
        for (value) in self.values():
            countSum += value
        return countSum

    def different_elements(self):
        """Returns the number of different words in a histogram."""
        # TODO: Add your code
        return len(self)

    def random_element(self):
        """Chooses a random word from a histogram.

        The probability of each word is proportional to its frequency.
        returns: string a single words
        """
        # TODO: Add your code
        return random.choice(list(self))


def test(title, produced, expected):
    print("*** Test {}".format(title))
    if produced == expected:
        print("   PASS")
    else:
        print("   FAIL")
        print("   expected {}".format(expected))
        print("   produced {}".format(produced))


if __name__ == '__main__':

    a = [1, 2, 3, 1, 1, 2]
    b = 'Hello Calgary! What a great day. Calgary is a great city.'
    c = b.split()

    hist_int = Histogram()
    hist_int.count(a)
    newHist = Histogram([1, 2, 3])

    hist_char = Histogram(b)

    hist_word = Histogram(c)
    print(str(hist_char))
    test("Initialize with count()",
    str(hist_int),
    "(3 count of 1)\n(2 count of 2)\n(1 count of 3)")

    test("int hist most_common all",
    str(hist_int.most_common()),
    "[(1, 3), (2, 2), (3, 1)]")

    test("char hist most_common n=3",
    str(hist_char.most_common(n=3)),
    "[('a', 10), (' ', 10), ('y', 4)]")

    test("word hist most_common n=5",
    str(hist_word.most_common(n=5)),
    "[('great', 2), ('a', 2), ('is', 1), ('day.', 1), ('city.', 1)]")
