import stack


class Expression:
    def __init__(self, exp):
        self.expression = exp

    def evaluate(self):
        prec = {"*": 3, "/": 3, "+": 2, "-": 2, "(": 1}
        # assigning precidence to operators
        operators = stack.Stack()
        operands = stack.Stack()
        # 2 stacks: 1 for operators, 1 for operands

        tokenList = self.expression.split()
        for token in tokenList:
            if token in "1234567890":
                operands.push(int(token))
                # push operand onto operands stack
            elif token == "(":
                operators.push(token)
                # always push ( on operators stack
            elif token == ")":
                top = operators.pop()
                while top != "(":  # pop until finds (
                    num2 = operands.pop()
                    num1 = operands.pop()
                    if top == "*":
                        num3 = num1 * num2
                    elif top == "/":
                        num3 = num1 / num2
                    elif top == "+":
                        num3 = num1 + num2
                    else:
                        num3 = num1 - num2
                    operands.push(num3)
                    # maths
                    top = operators.pop()
            else:
                # never bury an operator of higher or equal precidence
                while (not operators.isEmpty()) and (prec[operators.peek()] >= prec[token]):
                    op = operators.pop()
                    num2 = operands.pop()
                    num1 = operands.pop()
                    if op == "*":
                        num3 = num1 * num2
                    elif op == "/":
                        num3 = num1 / num2
                    elif op == "+":
                        num3 = num1 + num2
                    else:
                        num3 = num1 - num2
                    operands.push(num3)
                    # maths
                operators.push(token)

        # empty operators stack
        while not operators.isEmpty():
            op = operators.pop()
            num2 = operands.pop()
            num1 = operands.pop()
            if op == "*":
                num3 = num1 * num2
            elif op == "/":
                num3 = num1 / num2
            elif op == "+":
                num3 = num1 + num2
            else:
                num3 = num1 - num2
            operands.push(num3)
            # maths
        return operands.pop()
        # return last item on operators stack

    def __str__(self):
        return self.expression


def main():
    f = open("infix.txt", "r")
    for aline in f:
        aline = aline[:-1]
        e = Expression(aline)
        print(e, "=", e.evaluate())

main()
