import copy

from spanning_tree import kruskal
from matcher import get_match

graph = {}
for line in open('input').readlines():
    v1, v2, weight = map(int, line.split(' '))
    try:
        graph[v1].append({v2: weight})
    except KeyError:
        graph[v1] = [{v2: weight}]
    try:
        graph[v2].append({v1: weight})
    except KeyError:
        graph[v2] = [{v1: weight}]
print(graph)
T = kruskal(copy.deepcopy(graph))
O = {vertex: [vert for vert in graph[vertex] if len(graph[vert.popitem()[0]]) % 2] for vertex in T if len(graph[vertex]) % 2}
print(T)
print(O)
get_match(T)


