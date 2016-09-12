from copy import deepcopy


def pos_max(matr):
    max = matr[0][0]
    position = (0, 0)
    for i in range(len(matr)):
        for j in range(len(matr[i])-1):
            if abs(matr[i][j]) > max:
                max = abs(matr[i][j])
                position = (i, j)
    return position


def input_matrix():
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([int(j) for j in input().split()])
    return matrix


def swap_elements(matr, position):
    matr[0], matr[position[0]] = matr[position[0]], matr[0]
    for i in range(len(matr)):
        matr[i][0], matr[i][position[1]] = matr[i][position[1]], matr[i][0]


def make_one(matr, i):
    d = 1. / matr[i][i]

    for k in range(len(matr[i])-1):
        matr[i][k] *= d

    matr[i][len(matr[i])-1] *= d
    return matr


def make_zero(a, i, j):
    n = len(a)
    m = len(a[0])-1

    for k in range(n):
        if k != i and a[k][j] == 1:
            break

    d = a[i][j]

    for l in range(m):
        a[i][l] -= a[k][l]*d

    a[i][len(a[0])-1] -= a[k][len(a[0])-1]*d

    return a


def solve(a):
    n = len(a)
    m = len(a[0])

    a = deepcopy(a)

    for j in range(m-1):
        print_matrix(a)
        swap_elements(a, pos_max(a))
        a = make_one(a, j)
        for i in range(n):
            if i != j:
                a = make_zero(a, i, j)

    return a


def print_matrix(matr):
    for i in range(len(matr)):
        print(str(matr[i]), ' ')


matrix = input_matrix()
print(matrix)
solve(matrix)
print(solve(matrix))
