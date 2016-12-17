n = int(input("Enter n: "))

g = []

for i in range(n):
    g.append([int(c) for c in input() if c != ' '])

print(g)


def dfs(used, matching, v):
    if used[v - 1]:
        return False
    used[v - 1] = True
    for to in g[v - 1]:
        if matching[to-1] == -1 or dfs(used, matching, matching[to-1]):
            matching[to-1] = v
            return True
    return False


def main():
    matching = [-1 for i in range(n)]
    for i in range(n):
        used = [False for j in range(n)]
        dfs(used, matching, i + 1)
    for i in range(n):
        if matching[i] != -1:
            print(i + 1, " ", matching[i])


main()
