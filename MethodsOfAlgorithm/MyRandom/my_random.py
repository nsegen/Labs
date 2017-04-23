from random import random

import sys

from square_random import SquareRandom
from no_name_random import NoNameRandom


def mathematical_expected(numbers):
    return sum(numbers) / len(numbers)


def dispersion(numbers):
    return mathematical_expected(list(map(lambda x: x**2, numbers))) - mathematical_expected(numbers)**2


rand = SquareRandom(1927, 0, 1)
square_random_numbers = [i[0] for i in zip(rand, range(100000))]
print(square_random_numbers)
print(mathematical_expected(square_random_numbers), dispersion(square_random_numbers))

rand = NoNameRandom(19, 0, 1)
no_name_random_numbers = [i[0] for i in zip(rand, range(100000))]
print(no_name_random_numbers)
print(mathematical_expected(no_name_random_numbers), dispersion(no_name_random_numbers))

standard_random_numbers = [random() for i in range(100000)]
print(standard_random_numbers)
print(mathematical_expected(standard_random_numbers), dispersion(standard_random_numbers))



