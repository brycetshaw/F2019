import os
import re


def importfile(file):
    local = os.getcwd()
    fin = open(local + '/' + file, "r")
    words = fin.read()
    fin.close()
    return words


def uses_only(word, available):
    for letter in word:
        if letter not in available:
            return False
    return True


def avoids(word, avoid):
    for letter in word:
        if letter in avoid:
            return True
        return False


def abra(word):
    first = "a"
    for letter in word:
        if letter < first:
            return False
        first = letter
    return True


def letterFrequencySet(words):
    # alphabetCount = np.zeros((26, 2))
    alphabetCount = []
    alphabetIndex = ord('a')

    for x in range(26):
        alphabetCount.append([0, chr(x + alphabetIndex)])

    for word in words:
        for x in range(26):
            if avoids(chr(alphabetIndex+x), word):  # checks if 'a' ... 'z' is in 'ababa'
                alphabetCount[x][0] += 1
    return alphabetCount


def part11(words):
    words = words.split('\n')
    words = list(filter(None, words))
    numWords = len(words)
    averageLength = 0
    maxLength = 0
    allVowels = 0
    abraWords = 0

    for word in words:
        averageLength += len(word)
        maxLength = len(word) if len(word) > maxLength else maxLength
        allVowels = allVowels + 1 if uses_only(word, 'aeiou') else allVowels
        abraWords = abraWords + 1 if abra(word) else abraWords
    averageLength /= numWords

    message = (
        f"Part 1.1 \n"
        f"number of words is: {numWords}\n"
        f"Average word length is: {round(averageLength,2)}\n"
        f"maximum word length is: {maxLength}\n"
        f"number of all vowel words is: {allVowels}\n"
        f"number of abecedarian words is: {abraWords}\n\n"

    )
    print(message)


def part12(words):
    words = words.split('\n')
    words = list(filter(None, words))
    alphabetCount = letterFrequencySet(words)
    alphabetCount = sorted(alphabetCount, key=lambda x: x[0])
    leastForbidden = ""
    for x in range(5):
        leastForbidden += alphabetCount[x][1]

    print(
        f"Part 1.2 \n"
        f"The 5 least frequent letters are: {leastForbidden}\n\n")


def part2(feynman):
    feynman = feynman.replace('\n', '')
    feynmanWords = re.sub("\.|\,|\!|\?|\;", '', feynman)
    wordCount = 0
    sentenceCount = 0
    breaksCount = 0
    words = feynmanWords.split(" ")
    words = list(filter(None, words))
    sentences = re.split("\.|\!|\?", feynman.strip())
    sentences = list(filter(None, sentences))
    brokenSentences = re.split("\.|\!|\?|\;|\,", feynman.strip())
    brokenSentences = list(filter(None, brokenSentences))

    wordCount = len(words)
    sentenceCount = len(sentences)
    breaksCount = len(brokenSentences)
    pronouns = 0
    pronouns += feynman.count('I') + feynman.count("you") + \
        feynman.count("my") + feynman.count("you")+feynman.count("we")

    for element in words:
        if element is "you":
            pronouns += 1

    print(
        f"Part 2 \n"
        f"In the Introduction section 1.1 of the feynmann lectures... \n"
        f"The number of words is: {wordCount}\n"
        f"The number of sentences is: {sentenceCount}\n"
        f"The average words per sentence is: {round(wordCount/sentenceCount,2)}\n"
        f"The average number of sentence parts is: {round(breaksCount/sentenceCount,2)}\n"
        f"The number of personal pronouns is: {pronouns}\n"

    )


def check(cardNumber):

    numbers = cardNumber.split(" ")
    checkSum = 0
    for set in numbers:
        if len(set) != 4:
            return False
        for digit in set:
            checkSum += int(digit, 10)

    if checkSum % 10 == 0:
        return True
    else:
        return False


def answer(validity):
    if validity:
        return("This is a valid card number.")
    else:
        return("This IS NOT a valid card number.")


def part3():
    print("Part 3 \n")
    while True:
        card = input("Enter your card number:")
        print(answer(check(card)))


words = importfile('words.txt')
feynman = importfile('feynman.txt')

part11(words)
part12(words)
part2(feynman)
part3()
