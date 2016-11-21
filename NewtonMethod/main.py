from math import log


def dx(f, x):
    return abs( 0 -f(x))


def newtons_method(f, df, x0, e):
    delta = dx(f, x0)
    while delta > e:
        x0 = x0 - f(x0 ) /df(x0)
        delta = dx(f, x0)
    print('Root is at: ', x0)
    print('f(x) at root is: ', f(x0))

# функция
def F(x):
    return 0.1 * pow(x, 2) - x * log(x)


# производная
def F1(x):
    return 0.2 * x - log(x) - 1


def Method(a, b):
    try:
        x0 = (a + b) / 2
        xn = F(x0)
        xn1 = xn - F(xn) / F1(xn)
        while abs(xn1 - xn) > pow(10, -5):
            xn = xn1  # вот так надо было
            xn1 = xn - F(xn) / F1(xn)
        return xn1
    except ValueError:
        print("Value not invalidate")