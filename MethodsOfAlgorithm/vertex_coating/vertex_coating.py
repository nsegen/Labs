from find_coating_variants.full_search import full_search
from find_coating_variants.greedy_algorithm import greedy_algorithm
from find_coating_variants.lazy_algorithm import lazy_algorithm
import copy
import time

graph = {}
edge = 1
for i in open('input').readlines():
    graph[edge] = [int(x) for x in i.split(' ')]
    edge += 1
print(graph)

start = time.time()
print(full_search(graph))
print(time.time() - start)
start = time.time()
print(greedy_algorithm(copy.deepcopy(graph)))
print(time.time() - start)
start = time.time()
print(lazy_algorithm(copy.deepcopy(graph)))
print(time.time() - start)
