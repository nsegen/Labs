class NoNameRandom:
    amount_of_bits = 8
    start = 19643723

    def get_k(self):
        return 8 * self.p + 3

    def __init__(self, p, a=0, b=1):
        self.p = p
        self.current_state = self.start * self.get_k()
        self.a = a
        self.b = b

    def __str__(self):
        return '{} '.format(self.current_state)

    def next(self):
        self.current_state *= self.get_k()
        self.current_state %= 10 ** 8
        return float('0.{}'.format(self.current_state)) * (self.b - self.a) + self.a

    def __iter__(self):
        while True:
            yield self.next()
