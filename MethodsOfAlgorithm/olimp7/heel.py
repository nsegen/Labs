file = open('in', 'r')
n = file.readline()
heels = [int(height) for height in file.readline().split(' ')]
v = 0

start = None


def get_next_heel(hells):

    heels.append(0)
    for i in range(len(heels)):
        if heels[i - 1] < heels[i] and heels[i + 1] < heels[i]:
            yield i

for i in get_next_heel(heels):
    if start is not None:
        m = min(heels[start], heels[i])
        v += sum([m - h for h in heels[start+1:i]])
    start = i

print(v)
