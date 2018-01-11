def com(n, m):
    if m == 0 or m == n:
        return 1
    else:
        return com(n - 1, m - 1) + com(n - 1, m)


# testing code
print(com(0, 0))
print(com(2, 1))
print(com(3, 2))
print(com(4, 2))
print(com(4, 3))
