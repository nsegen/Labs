import math

import sys

s = int(input('enter s: '))


def area(a, b, c):
    p = (a + b + c) / 2
    d = p * (p - a) * (p - b) * (p - c)
    if d > 0:
        return math.sqrt(p * (p - a) * (p - b) * (p - c))
    return 0

triangles = set()
P = sys.maxsize

for i in range(1, 2 * s + 1):
    for j in range(1, 2 * s + 1):
        for k in range(1, 2 * s + 1):
            if area(i, j, k) == s:
                triangle = [i, j, k]
                triangle.sort()
                triangles.add((triangle[0], triangle[1], triangle[0]))
                P = min(P, sum(triangle))

print(len(triangles), P)
