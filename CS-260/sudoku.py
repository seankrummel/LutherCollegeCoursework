import fileinput

def s(row, column, value):
    return 81 * (row - 1) + 9 * (column - 1) + value

disjunctions = ""

# there is at least one number in each entry
for x in range(1, 10):
    for y in range(1, 10):
        for z in range(1, 10):
            disjunctions += '{0:d} '.format(s(x, y, z))
        disjunctions += "0\n"

# each number appears at most once in each row
for y in range(1, 10):
    for z in range(1, 10):
        for x in range(1, 9):
            for i in range(x + 1, 10):
                disjunctions += '-{0:d} -{1:d} 0\n'.format(s(x, y, z), s(i, y, z))

# each number appears at most once in each column
for x in range(1, 10):
    for z in range(1, 10):
        for y in range(1, 9):
            for i in range(y + 1, 10):
                disjunctions += '-{0:d} -{1:d} 0\n'.format(s(x, y, z), s(x, i, z))

# each number appears at most once in each 3x3 sub-grid
for z in range(1, 10):
    for i in range(0, 3):
        for j in range(0, 3):
            for x in range(1, 4):
                for y in range(1, 4):
                    for k in range(y + 1, 4):
                        disjunctions += '-{0:d} -{1:d} 0\n'.format(s(3 * i + x, 3 * j + y, z),
                                                                   s(3 * i + x, 3 * j + k, z))
                    for k in range(x + 1, 4):
                        for l in range(1, 4):
                            disjunctions += '-{0:d} -{1:d} 0\n'.format(s(3 * i + x, 3 * j + y, z),
                                                                       s(3 * i + k, 3 * j + l, z))

numdis = 8829  # minimal encoding will have 8829 disjunctions

fin = fileinput.input('sudokuinput.txt')
rows = 0
for row in fin:
    rows += 1
    col = row.split()
    cols = 0
    for val in col:
        cols += 1
        if val != 'x':
            disjunctions += '{:d} 0\n'.format(s(rows, cols, int(val))) # the given value must be true
            numdis += 1 # add one to the number of disjunctions



line1 = 'p cnf 729 {0:d}\n'.format(numdis)  # first line is 'p cnf numvars(729) numdis'
file = open('sudoku.txt', 'w')
file.write(line1 + disjunctions)
file.close()
