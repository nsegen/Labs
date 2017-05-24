n = int(input('Enter n: '))
temp = list(map(lambda d: (int(d.split('/')[0]), int(d.split('/')[1])), input('Enter w/p list: ').split(' ')))
w, p = zip(*temp)
W = int(input('Enter W: '))

A = [[0 for i in range(W)] for j in range(n + 1)]
ans = []


def get_ans(k, s):
    print(k, s)
    if A[k][s] == 0:
        return;
    if A[k-1][s] == A[k][s]:
        get_ans(k-1, s)
    else:
        get_ans(k-1, s - w[k - 1])
        ans.append(k)

for k in range(1, n + 1):
    for s in range(W):
        if s >= w[k-1]:
            A[k][s] = max(A[k-1][s], A[k-1][s -w[k - 1]]+p[k - 1])
        else:
            A[k][s] = A[k-1][s]
for a in A:
    print(a)

get_ans(n, W - 1)
print(ans, A.pop().pop())
