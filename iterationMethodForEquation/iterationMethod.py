def f(x):
    return pow(x, 3) - 1.5 * pow(x, 2) + 0.58 * x - 0.057


def f_der_first(x):
    return 3 * pow(x, 2) - 3 * x + 0.58


def f_der_second(x):
    return 6 * x - 3


def fi(x, c):
    return x + c * (pow(x, 3) - 1.5 * pow(x, 2) + 0.58 * x - 0.057)


a = 0.0
b = 0.3
x = 0.01
eps = 0.001

current = x
c = -1 * pow(f_der_first(x), -1)

if f(a) * f(b) < 0:
    test = c * f_der_first(a) + 1
    if abs(c * f_der_first(a) + 1) <= 1:
        while True:
            previous = current
            current = fi(previous, c)
            if abs(current - previous) < eps:
                break
print(current)
