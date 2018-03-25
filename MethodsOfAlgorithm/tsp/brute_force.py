import itertools


def brute_force_tsp(graph):

	return min(itertools.permutations(range(len(graph))), key=lambda path: sum(map(lambda v: graph[v[0]][v[1]], zip(path, list(path[1:]) + [path[0]]))))