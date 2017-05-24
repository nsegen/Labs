from random import random
import math

res = []

f = lambda t: (t[2] and not t[3] and not t[0]) or (t[0] and t[3]) or (not t[2] and t[3]) or (t[2] and t[3] and not t[1]) or (not t[2] and not t[1])

def get_random_vector(size):

    vec = []

    for i in range(size):
        vec.append(True if random() < 0.5 else False)
    return vec

def monte_carlo(size, eps, delta):
    s = 0
    n = round((3*math.log(2/delta)) / (eps ** 2))

    for i in range(n):
        tmp = get_random_vector(size)
        if f(tmp):
            s += 1
            if tmp not in res:
                res.append(tmp)
    return (2 ** size) * s // n

print(monte_carlo(4, 0.1, 0.05))
print(res)
