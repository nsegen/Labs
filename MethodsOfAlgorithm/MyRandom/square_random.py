import sys


class SquareRandom:
    amount_of_bits = 4

    def __init__(self, number, a=0, b=1):
        self.current_state = number
        self.a = a
        self.b = b

    def __str__(self):
        return '{} '.format(self.current_state)

    def next(self):
        self.current_state **= 2
        temp_str = str(self.current_state).zfill(self.amount_of_bits)
        n = (len(temp_str) - self.amount_of_bits) // 2
        self.current_state = int(temp_str[n:-n])

        return float('0.{}'.format(self.current_state)) * (self.b - self.a) + self.a

    def __iter__(self):
        while True:
            yield self.next()
