import math


def f(x, y):
    return -(x * y)/((1 - x ** 2) ** (1/2))


def get_next(x, y, h):
    for i in x:
        y += h * f(i, y)
        yield y + h * f(i, y)


def get_next_coshi(x, y, x_n, y1):
    for i in y1:
        y += 0.1 * (f(x, y) + f(x_n, i)) / 2
        x += 0.1
        yield y


a = 0
b = 1
h = 0.1

mass_x = [i / 10 for i in range(a * 10, b * 10)]
mass_x2 = [i / 100 for i in range(a * 100, b * 100, 5)]
mass = [i for i in get_next(mass_x, math.e, 0.1)]
mass2 = [i for i in get_next(mass_x2, math.e, 0.05)]
mass3 = [i for i in get_next_coshi(0, math.e, 0.1, mass)]

print(mass)
print(mass2)
print(mass3)
