class Node:
    def __init__(self, newitem):
        self.data = newitem
        self.left = None
        self.right = None

    def setData(self, newdata):
        self.data = newdata

    def setLeft(self, newleft):
        self.left = newleft

    def setRight(self, newright):
        self.right = newright

    def getData(self):
        return self.data

    def getLeft(self):
        return self.left

    def getRight(self):
        return self.right


class morseTree:
    def __init__(self):
        self.root = Node("root")
        self.buildTree()

    def buildTree(self):
        f = open("morse.txt", "r")
        for line in f:
            morse = line[:-3]
            key = line[-3:-1]
            # seperate the morse code from the character
            current = self.root
            for x in morse:
                prev = current
                if x == ".":
                    current = prev.getLeft()
                    if current is None:
                        prev.setLeft(Node(key))
                elif x == "-":
                    current = prev.getRight()
                    if current is None:
                        prev.setRight(Node(key))
        f.close()

    def decode(self, code):  # code is just one line
        node = self.root
        out = ""
        for c in code:
            if c == ".":
                node = node.getLeft()
                # if . go left
            elif c == "-":
                node = node.getRight()
                # if - go right
            elif c == " ":
                out += node.getData()
                node = self.root
                # space means character is done, reset to root
        out += node.getData()
        # make sure to get data when line is done
        return out


def main():
    t = morseTree()
    f = open("message.txt", "r")
    for line in f:
        print(t.decode(line))


main()
