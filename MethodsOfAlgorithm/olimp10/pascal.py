import math

i, j = [int(l) - 1 for l in input().split(' ')]
print(math.factorial(i)/(math.factorial(j) * math.factorial(i - j)))
