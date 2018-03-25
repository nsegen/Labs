import itertools

def generate_locals(path, changes):
	edges_pairs = [pair for pair in itertools.permutations(itertools.permutations(path, 2), changes) if pair[0][0] != pair[1][0] and pair[0][1] != pair[1][1]]
	for edge_pair in edges_pairs:
		print(edge_pair)
	return list()


def local_search(graph, path, changes):
	return generate_locals(path, changes)



def local_search_2_tsp(graph):
	return local_search(graph, range(len(graph)), 2)
