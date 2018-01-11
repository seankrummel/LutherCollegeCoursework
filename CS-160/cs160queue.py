class Queue:
    def __init__(self):
        self.items = []

    def enqueue(self, newitem):
        self.items.append(newitem)

    def dequeue(self):
        return self.items.pop(0)

    def size(self):
        return len(self.items)

    def isEmpty(self):
        return len(self.items) == 0

    def __str__(self):
        return "Front" + str(self.items) + "Rear"


def main():
    myq = Queue()

    print(myq)
    print(myq.isEmpty())
    myq.enqueue(1)
    myq.enqueue(2)
    myq.enqueue(3)
    myq.enqueue(4)
    myq.enqueue(5)
    print(myq)
    print(myq.size())
    print(myq.isEmpty())
    print(myq.dequeue())
    print(myq.dequeue())
    print(myq)

    while not myq.isEmpty():
        temp = myq.dequeue()
        print(temp)


if __name__ == "__main__":
    main()
