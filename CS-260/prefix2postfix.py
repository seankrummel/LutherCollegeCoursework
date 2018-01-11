import io
import streamreader


class Plus:
    def __init__(self, left, right):
        self.left = left
        self.right = right

    def __repr__(self):
        return repr(self.left) + repr(self.right) + " +"


class Minus:
    def __init__(self, left, right):
        self.left = left
        self.right = right

    def __repr__(self):
        return repr(self.left) + repr(self.right) + " -"


class Times:
    def __init__(self, left, right):
        self.left = left
        self.right = right

    def __repr__(self):
        return repr(self.left) + repr(self.right) + " *"


class Divide:
    def __init__(self, left, right):
        self.left = left
        self.right = right

    def __repr__(self):
        return repr(self.left) + repr(self.right) + " /"


class Num:
    def __init__(self, val):
        self.val = val

    def __repr__(self):
        return " " + str(self.val)


def E(reader):
    token = reader.getToken()
    if token == "+":
        return Plus(E(reader), E(reader))
    if token == "-":
        return Minus(E(reader), E(reader))
    if token == "*":
        return Times(E(reader), E(reader))
    if token == "/":
        return Divide(E(reader), E(reader))

    return Num(int(token))


def parse(reader):
    tree = E(reader)
    t = reader.getToken()
    if not t == chr(streamreader.EOF):
        raise Exception("Parse Error")
    return tree


if __name__ == '__main__':
    s = input("Please enter a postfix expression (or press enter to stop): ")
    while not s == "":
        # print(s)
        strm = io.StringIO(s)
        strmreader = streamreader.StreamReader(strm)
        tree = parse(strmreader)
        # print(tree)
        print("The postfix form is:" + str(tree))
        s = input("Please enter a postfix expression (or press enter to stop): ")
