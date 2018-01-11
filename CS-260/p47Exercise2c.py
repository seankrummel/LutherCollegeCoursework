import state
import io
import streamreader

EOF = 3
NoTransition = -1


class FiniteStateMachine:
    def __init__(self, states, startStateId, classes):
        self.states = states
        self.startStateId = startStateId
        self.classes = classes

        for stateId in self.states:
            self.states[stateId].setClasses(classes)

    def accepts(self, strm):
        currentstate = self.startStateId
        currenttoken = strm.readChar()
        while currenttoken != chr(EOF):
            currentstate = self.states[currentstate].onClassGoTo(currenttoken)
            if currentstate == NoTransition:
                return "That string is not accepted.\n"
            currenttoken = strm.readChar()
        if self.states[currentstate].getAcceptsTokenId() == 1:
            return "That string is accepted by this finite state machine.\n"
        else:
            return "That string is not accepted.\n"


def main():
    q0 = state.State(0, 1)
    q1 = state.State(1, 1)
    q2 = state.State(2, 1)
    q3 = state.State(3, 1)
    q4 = state.State(4)
    classes = {"a": frozenset("a"), "b": frozenset("b")}

    q0.addTransition("a", 1)
    q0.addTransition("b", 0)
    q1.addTransition("a", 2)
    q1.addTransition("b", 1)
    q2.addTransition("a", 3)
    q2.addTransition("b", 2)
    q3.addTransition("a", 4)
    q3.addTransition("b", 3)
    q4.addTransition("a", 4)
    q4.addTransition("b", 4)

    dfa = FiniteStateMachine({0: q0, 1: q1, 2: q2, 3: q3, 4: q4}, 0, classes)

    # You must complete the main function here but you can
    # create a stream over a string s by writing
    # strm = streamreader.StreamReader(io.StringIO(s))
    s = raw_input("Please enter a string of a's and b's: ")
    # apparently I'm using python 2.7 instead of 3.x, so I need to use raw_input() instead of input()
    # REMEMBER TO CHANGE AFTER UPDATING PYTHON!!

    while s != "":
        strm = streamreader.StreamReader(io.StringIO(s))
        print(dfa.accepts(strm))
        s = raw_input("Please enter a string of a's and b's: ")
        # REMEMBER TO CHANGE AFTER UPDATING PYTHON!!

if __name__ == "__main__":
    main()
