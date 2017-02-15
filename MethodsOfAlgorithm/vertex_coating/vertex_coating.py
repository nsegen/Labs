from find_coating_variants.full_search import full_search
from find_coating_variants.greedy_algorithm import greedy_algorithm
from find_coating_variants.lazy_algorithm import lazy_algorithm
import copy

graph = {}
edge = 1
for i in open('input').readlines():
    graph[edge] = [int(x) for x in i.split(' ')]
    edge += 1
print(graph)

print(full_search(graph))

print(greedy_algorithm(copy.deepcopy(graph)))

print(lazy_algorithm(copy.deepcopy(graph)))
