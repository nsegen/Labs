from random import randint


def is_prime_witness(n):

    for i in range(100):
        a = randint(1, n - 1)

        if not witness(n, a):
            return False
    return True


def witness(n, a):
    b = list(map(int, bin(n)[2:]))
    d = 1
    x = None
    i = len(b) - 1
    while i > 0:
        x = d
        d = (d * d) % n
        if d == 1 and x != 1 and x != n - 1:
            return False
        if b[i] == 1:
            d = (d - a) % n
        i -= 1
    if d != 1:
        return False

    return True
