import streamreader
import io
import stack
import copy

epsilon = ""

class NPDA:
    def __init__(self, delta, startStateId, stackStartSym, finalStates):
        self.delta = delta
        self.startStateId = startStateId
        self.stackStartSym = stackStartSym
        self.finalStates = finalStates

    # recursive version
    # def accepts(self, strm):
    #     def matchTop(aStackTop, stack):
    #         return aStackTop == stack[-1]
    #
    #     def getTransitions(stateId, stack):
    #         transitionList = []
    #         for aStateId, anInputSymbol, aStackTop in self.delta.keys():
    #             if stateId == aStateId and matchTop(aStackTop, stack):
    #                 transitionList.append((anInputSymbol, aStackTop))
    #         return transitionList
    #
    #     def popPush(aStackTop, pushOnStack, stack):
    #         newstack = stack[:]
    #         for x in aStackTop:
    #             newstack.pop()
    #         for x in pushOnStack[::-1]:
    #             newstack.append(x)
    #         return newstack
    #
    #     def acceptsSuffix(stateId, stack):
    #         c = strm.readChar()
    #         # print((stateId, c, stack[::-1]))
    #         # this print statement will show the instantanious description
    #         if strm.eof() and stateId in self.finalStates:
    #             return True
    #         strm.unreadChar(c)
    #
    #         for anInputSymbol, aStackTop in getTransitions(stateId, stack):
    #             for toStateId, pushOnStack in self.delta[stateId, anInputSymbol, aStackTop]:
    #                 if anInputSymbol == epsilon and acceptsSuffix(toStateId, popPush(aStackTop, pushOnStack, stack)):
    #                     return True
    #                 else:
    #                     c = strm.readChar()
    #                     if c == anInputSymbol and acceptsSuffix(toStateId, popPush(aStackTop, pushOnStack, stack)):
    #                         return True
    #                     strm.unreadChar(c)
    #         return False
    #
    #     return acceptsSuffix(self.startStateId, [self.stackStartSym])

    # This is an iterative version of accepts that works. It maintains
    # a stack of instantaneous descriptions that have yet to be explored.
    def accepts(self, strm):

        def matchTop(aStackTop, stack):
            return stack[-1] == aStackTop

        def getTransitions(stateId, stack):
            transitionList = []

            for aStateId, anInputSym, aStackTop in self.delta.keys():
                if stateId == aStateId and matchTop(aStackTop, stack):
                    transitionList.append((anInputSym, aStackTop))

            return transitionList

        def popPush(aStackTop, pushOnStack, stack):
            newstack = stack[:]
            for x in aStackTop:
                newstack.pop()
            for x in pushOnStack[::-1]:
                newstack.append(x)
            return newstack

        stateId = self.startStateId
        pdaStack = [self.stackStartSym]

        # This is the instantaneous description stack. It starts with the start state
        # instantaneous description.
        ID = stack.Stack()
        ID.push((stateId, strm, pdaStack))

        while not ID.isEmpty():
            stateId, strm, pdaStack = ID.pop()
            print((stateId, strm, pdaStack))
            c = strm.readChar()

            if strm.eof() and stateId in self.finalStates:
                return True

            strm.unreadChar(c)

            for anInputSym, aStackTop in getTransitions(stateId, pdaStack):
                for toStateId, pushOnStack in self.delta[(stateId, anInputSym, aStackTop)]:
                    if anInputSym == epsilon:
                        ID.push((toStateId, copy.deepcopy(strm), popPush(aStackTop, pushOnStack, pdaStack)))
                    else:  # not an epsilon transition
                        c = strm.readChar()
                        if c == anInputSym:
                            ID.push((toStateId, copy.deepcopy(strm), popPush(aStackTop, pushOnStack, pdaStack)))
                        strm.unreadChar(c)

        return False

if __name__ == '__main__':
    delta = {} # delta is the transition function (dictionary)
    # delta[(stateId, inputsym, stacktop)] = (newstateid, stacktop')

    # builds npda on page 179 of text not including the union with {a}
    # delta[(0, "a", "0")] = {(1, "10")}
    # delta[(0, epsilon, "0")] = {(3, "")}
    # delta[(1, "a", "1")] = {(1, "11")}
    # delta[(1, "b", "1")] = {(2, "")}
    # delta[(2, "b", "1")] = {(2, "")}
    # delta[(2, epsilon, "0")] = {(3, "")}

    # builds npda of ww^R language
    # delta[(0, "a", "a")] = {0, "aa"}
    # delta[(0, "b", "a")] = {0, "ba"}
    # delta[(0, "a", "b")] = {0, "ab"}
    # delta[(0, "b", "b")] = {0, "bb"}
    # delta[(0, "a", "z")] = {0, "az"}
    # delta[(0, "b", "z")] = {0, "bz"}
    # delta[(0, epsilon, "a")] = {1, "a"}
    # delta[(0, epsilon, "b")] = {1, "b"}
    # delta[(1, "a", "a")] = {1, ""}
    # delta[(1, "b", "b")] = {1, ""}
    # delta[(1, epsilon, "z")] = {2, ""}
    # delta[(0, epsilon, "z")] = {2, ""}

    # a^n b^2n, code provided in class, Chapter7Excercise4(a)
    delta[(0, "a", "0")] = {(1, "110")}
    delta[(0, epsilon, "0")] = {(3, "")}
    delta[(1, "a", "1")] = {(1, "111")}
    delta[(1, "b", "1")] = {(2, "")}
    delta[(2, "b", "1")] = {(2, "")}
    delta[(2, epsilon, "0")] = {(3, "")}

    npda = NPDA(delta, 0, "0", {3})
    x = input("Please enter a string of a's and b's: ")
    # x = ("a" * 1000) + ("b" * 2000)
    if npda.accepts(streamreader.StreamReader(io.StringIO(x))):
        print("Yes, in the language")
    else:
        print("Not in the language")