from functools import reduce
from random import randint


def quality(vector):
    return reduce(lambda a,b: a + b, vector)


def tweak(vector, n):
    v = vector.copy()
    i = randint(0, n-1)
    j = randint(0, n-1)
    (v[i], v[j]) = (v[j], v[i])
    p = randint(0, n-1)
    v[p] = 0 if v[p] == 1 else 1
    return v


n = 20
solution = [randint(0, 1) for i in range(n)]

while True:
    print(solution)
    r = tweak(solution, n)
    if quality(r) > quality(solution):
        solution = r
    if quality(solution) == n:
        break

print(solution)
