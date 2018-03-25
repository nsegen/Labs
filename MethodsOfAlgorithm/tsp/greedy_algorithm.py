def greedy_tsp(graph, vertex=0):
	v = graph[vertex].index(min(graph[vertex]))
	if graph[vertex][v] == float('inf'):
		return [vertex]
	for row in graph:
		row[vertex] = float('inf')
	return [vertex] + greedy_tsp(graph, v)