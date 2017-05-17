def primes(n):

    numbers = list(range(2, n + 1))
    ansver = []
    while len(numbers) > 0:
        i = numbers[0]
        ansver.append(i)
        for j in range(i, numbers[len(numbers) - 1] + 1, i):
            if j in numbers:
                numbers.remove(j)
    return ansver
