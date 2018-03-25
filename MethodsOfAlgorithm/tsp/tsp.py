import random
import copy
from greedy_algorithm import greedy_tsp
from brute_force import brute_force_tsp
from local_search import local_search_2_tsp


n = 5
graph = [[random.randint(1, n) if i != j else float('inf') for j in range(n)] for i in range(n)]

print(graph)
result_greedy = greedy_tsp(copy.deepcopy(graph))
result_brute_force = brute_force_tsp(copy.deepcopy(graph))
local_search_2 = local_search_2_tsp(copy.deepcopy(graph))

print(result_greedy)
print(result_brute_force)
print(local_search_2)