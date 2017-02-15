def f(x, y):
    return y ** 2 + y/x + 1/(x ** 2)


def values(x, y, h):
    for i in range(6):
        k1 = h * f(x, y)
        k2 = h * f(x + h / 2, y + k1 / 2)
        k3 = h * f(x + h / 2, y + k2 / 2)
        k4 = h * f(x + h, y + k3)

        delta_y = (k1 + 2 * k2 + 2 * k3 + k4) / 6
        y += delta_y
        yield x, y
        x += h


y_1 = 0
h = 0.01
a = 1
b = 1.5

for val in values(a, y_1, h):
    print(val)

