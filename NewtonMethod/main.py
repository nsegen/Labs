# функция
def f(x):
    return pow(x, 3) - 3 * pow(x, 2) - 14 * x - 8


# производная
def f_der_1(x):
    return 3 * pow(x, 2) - 6 * x - 14


def f_der_2(x):
    return 6 * x - 6


def newton_method(a, b):
    current = -2.5
    current0 = f(current)
    eps = pow(10.0, -3.0) / 2.0
    try:
        if f(current) * f_der_2(current) > 0 and f(a) * f(b) < 0:
            while True:
                previous = current
                current = previous - ((b - previous) * f(previous)) / (f(b) - f(previous))
                if abs(current - previous) < eps:
                    break
    except ValueError:
        print("Value not invalidate")

    return current

print(newton_method(-3, -1.9))
