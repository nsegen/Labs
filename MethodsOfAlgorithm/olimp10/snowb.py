def result(heels, heel, i):
    if heel == len(heels) - 1:
        return heels[heel][i]
    summ = heels[heel][i] + max(result(heels, heel + 1, i), result(heels, heel + 1, i + 1))
    return summ

print(result([[int(n) for n in line.split(' ')] for line in open('in').readlines()], 0, 0))
