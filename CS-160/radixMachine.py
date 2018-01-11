# Sean Krummel
# RadixMachine
# This program will create a virtual radix machine to sort a deck

import random
import queue  # queue.py contains the class Queue


class RadixMachine:
    def __init__(self):
        self.mainBin = queue.Queue()
        self.digitBins = []
        for i in range(10):
            self.digitBins.append(queue.Queue())
            # create queue for mainBin and 10 queues for digitBins

    def load(self, adeck):
        for i in adeck:
            self.mainBin.enqueue(i)
            # loads adeck into mainBin

    def go(self):
        for i in range(3):  # run 3 times (3 digit numbers)
            while not self.mainBin.isEmpty():  # until mainBin has no more items
                card = self.mainBin.dequeue()
                digit = card % 10 ** (i + 1)
                if i != 0:
                    digit //= 10 ** i
                # maths to determine where to put the card
                self.digitBins[digit].enqueue(card)
            if i != 2:
                deck = self.unload()
                self.load(deck)
                # do not unload/reload on the last time

    def unload(self):
        deck = []
        for i in self.digitBins:
            while not i.isEmpty():
                deck.append(i.dequeue())
        return deck
        # empty all digitBins into deck list


def main(howmany):
    rm = RadixMachine()

    deck = []  # deck is a list
    for i in range(howmany):
        temp = random.randrange(1000)
        deck.append(temp)

    rm.load(deck)

    rm.go()

    sorteddeck = rm.unload()  # sorteddeck is a list

    for item in sorteddeck:
        print(item)


main(50)
