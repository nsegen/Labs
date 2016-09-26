def pick_nonzero_row(m, k):
    while k < m.shape[0] and not m[k, k]:
        k += 1
    return k


def get_identity_matrix(size):
    E = []
    for i in range(size):
        E.append([float(1 if i == j else 0) for j in range(size)])
    return E


def inverse(matr):
    n = len(matr[0])
    E = get_identity_matrix(n)
    m = []
    for i in range(n):
        m.append(matr[i])
        m[i].extend(E[i])

    # forward trace
    for k in range(n):
        # 1) Swap k-row with one of the underlying if m[k, k] = 0
        swap_row = pick_nonzero_row(m, k)
        if swap_row != k:
            m[k, :], m[swap_row, :] = m[swap_row, :], m[k, :].copy()
        # 2) Make diagonal element equals to 1
        if m[k, k] != 1:
            m[k, :] *= 1 / m[k, k]
        # 3) Make all underlying elements in column equal to zero
        for row in range(k + 1, n):
            m[row, :] -= m[k, :] * m[row, k]

    # backward trace
    for k in range(n - 1, 0, -1):
        for row in range(k - 1, -1, -1):
            if m[row, k]:
                # 1) Make all overlying elements equal to zero in the former identity matrix
                m[row, :] -= m[k, :] * m[row, k]

    res = []
    for i in range(n):
        E.append([float(m[i][n+j]) for j in range(n)])
    return m


def print_matrix(matr):
    for i in range(len(matr)):
        print(str(matr[i]), ' ')
    print("")


def input_matrix():
    n = int(input())
    matrix = []
    for i in range(n):
        matrix.append([float(j) for j in input().split()])
    return matrix

matrix = input_matrix()
print_matrix(matrix)
inv = inverse(matrix)
print_matrix(inv)
